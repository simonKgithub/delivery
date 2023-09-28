// 입력 창에 표시
let inputXPoint = document.getElementById('xPoint');
let inputYPoint = document.getElementById('yPoint');
let inputPlaceNm = document.getElementById('placeNm');
const nowLocationBtn = document.getElementById('nowLocation');

let geocoder = new kakao.maps.services.Geocoder(); // 주소-좌표 변환 객체를 생성
let marker = new kakao.maps.Marker();  // 클릭한 위치를 표시할 마커
let infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우

const mapContainer = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
let options = { //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(36.3376482, 127.3933957), //지도의 중심좌표(기본: 용문역).
    level: 3 //지도의 레벨(확대, 축소 정도)
};
const map = new kakao.maps.Map(mapContainer, options); //지도 생성 및 객체 리턴

// 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'idle', function() {
    searchAddrFromCoords(map.getCenter(), displayCenterInfo);
});

// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
            let detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
            detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';

            let content = '<div class="bAddr">' +
                '<span class="title">법정동 주소정보</span>' +
                detailAddr +
                '</div>';

            // 마커를 클릭한 위치에 표시합니다
            marker.setPosition(mouseEvent.latLng);
            marker.setMap(map);

            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
            infowindow.setContent(content);
            infowindow.open(map, marker);

            // input창에 지번주소를 표시합니다.
            inputPlaceNm.value = result[0].address.address_name;
        }
    });
});

// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
searchAddrFromCoords(map.getCenter(), displayCenterInfo);

// 현위치 찍기
nowLocationBtn.addEventListener('click', function(){
    currentLocation();
});

function searchDetailNowAddrFromCoords(coords, callback) {
    // 좌표를 입력창에 보여줍니다.
    inputXPoint.value = coords.latitude;
    inputYPoint.value = coords.longitude;
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(coords.longitude, coords.latitude, callback);
}
// 현위치 지도에 표출하기
function currentLocation() {
    // HTML5의 geolocation으로 사용할 수 있는지 확인합니다
    if (navigator.geolocation) {
        // GeoLocation을 이용해서 접속 위치를 얻어옵니다
        navigator.geolocation.getCurrentPosition(function(position) {
            searchDetailNowAddrFromCoords(position.coords, function(result, status){
                if (status === kakao.maps.services.Status.OK) {
                    let locPosition = new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude);
                    let content = '<div style="padding:5px;">현위치</div>'; // 인포윈도우에 표시될 내용

                    // 마커를 클릭한 위치에 표시합니다
                    marker.setPosition(locPosition);
                    marker.setMap(map);

                    // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                    infowindow.setContent(content);
                    infowindow.open(map, marker);

                    map.setCenter(locPosition);

                    // input창에 지번주소를 표시합니다.
                    inputPlaceNm.value = result[0].address.address_name;
                }
            });
        }, function(error){console.error(error)}, { enableHighAccuracy: true, });
    }
    return true
}

function searchAddrFromCoords(coords, callback) {
    // 좌표로 행정동 주소 정보를 요청합니다
    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
}
function searchDetailAddrFromCoords(coords, callback) {
    // 좌표를 입력창에 보여줍니다.
    inputXPoint.value = coords.getLat();
    inputYPoint.value = coords.getLng();
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}
// 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
function displayCenterInfo(result, status) {
    if (status === kakao.maps.services.Status.OK) {
        var infoDiv = document.getElementById('centerAddr');

        for(var i = 0; i < result.length; i++) {
            // 행정동의 region_type 값은 'H' 이므로
            if (result[i].region_type === 'H') {
                infoDiv.innerHTML = result[i].address_name;
                break;
            }
        }
    }
}