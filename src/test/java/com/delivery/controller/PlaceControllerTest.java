package com.delivery.controller;

import com.delivery.dto.PlaceNewsDto;
import com.delivery.dto.PlaceDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional //테스트에서 선언할 경우 테스트 종료 후 rollback 됨
@TestPropertySource(locations = "classpath:application-test.properties")
class PlaceControllerTest {
    @Autowired
    PlaceController placeController;

    @Test
    @DisplayName("place/newspaper 저장 테스트")
    public void saveTest(){
//        PlaceDto placeFormDto = this.makeDummyData();

//        placeController.postPlaceForm(placeFormDto);
    }

//    public PlaceDto makeDummyData(){
//        PlaceDto placeFormDto = new PlaceDto();
//        List<PlaceNewsDto> newspaperFormDtoList = new ArrayList<>();
//
//        placeFormDto.setXPoint("34.123");
//        placeFormDto.setYPoint("128.123");
//        placeFormDto.setPlaceNm("주소(지번)");
//        placeFormDto.setPlaceDesc("특징");
//        placeFormDto.setDeliveryOrder(1);
//
//        for (int i = 0; i < 5; i++) {
//            PlaceNewsDto newspaperFormDto = new PlaceNewsDto();
//            newspaperFormDto.setNewspaperNm("신문 경제" + i);
//            newspaperFormDto.setNewspaperDesc("신문 별명" + i);
//            newspaperFormDto.setCount(i);
//
//            newspaperFormDtoList.add(newspaperFormDto);
//        }
//
//        placeFormDto.setNewspaperFormDtoList(newspaperFormDtoList);
//
//        return placeFormDto;
//    }

}