package com.delivery.service;

import com.delivery.constant.DeliveryStatus;
import com.delivery.dto.AreaDto;
import com.delivery.dto.PlaceDto;
import com.delivery.dto.PlaceNewsDto;
import com.delivery.entity.Area;
import com.delivery.entity.News;
import com.delivery.entity.Place;
import com.delivery.entity.PlaceNews;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional //테스트에서 선언할 경우 테스트 종료 후 rollback 됨
@TestPropertySource(locations = "classpath:application-test.properties")
class AreaServiceTest {

    @Autowired
    AreaService areaService;
    @Autowired
    PlaceService placeService;
    @Autowired
    PlaceNewsService placeNewsService;

    @Test
    void deleteArea() {
        List<AreaDto> areaDtoList = this.makeDummyData();

        areaDtoList.forEach(areaDto -> {
            areaService.save(areaDto);
        });



        AreaDto areaDto = areaDtoList.get(0);
        Long areaId = areaDto.getAreaId();

        assertEquals(areaService.findAll().size(), 1);
        assertEquals(placeService.findPlacesWithNews(areaId).size(), 2);
        assertEquals(placeNewsService.findAllPlaceNews().size(), 2);

//        areaService.deleteArea(areaDtoList);
//
//        assertEquals(areaService.findAll().size(), 0);
//        assertEquals(placeService.findPlacesWithNews(areaId).size(), 2);
//        assertEquals(placeNewsService.findAllPlaceNews().size(), 2);
    }

    public List<AreaDto> makeDummyData() {
        List<AreaDto> areaDtoList = new ArrayList<>();

        Area area = new Area();
        area.setAreaId(1L);
        area.setAreaNm("areaNm");
        area.setAreaManager("areaManager");

        Place place1 = new Place();
        place1.setPlaceNm("placeNm");
        place1.setPlaceDesc("placeDesc");
        place1.setDeliveryStatus(DeliveryStatus.Y);
        place1.setXPoint("123");
        place1.setYPoint("456");
        place1.setId(1L);
        place1.setArea(area);
        PlaceDto placeDto1 = PlaceDto.of(place1);

        placeService.savePlace(placeDto1);


        Place place2 = new Place();
        place2.setPlaceNm("placeNm");
        place2.setPlaceDesc("placeDesc");
        place2.setDeliveryStatus(DeliveryStatus.Y);
        place2.setXPoint("123");
        place2.setYPoint("456");
        place2.setId(2L);
        place2.setArea(area);
        PlaceDto placeDto2 = PlaceDto.of(place2);

        placeService.savePlace(placeDto2);

        News news = new News();

        List<PlaceNewsDto> placeNewsDtoList = new ArrayList<>();

        PlaceNews placeNews1 = new PlaceNews();
        placeNews1.setNews(news);
        placeNews1.setPlace(place1);
        placeNews1.setId(1L);
        PlaceNewsDto placeNewsDto1 = PlaceNewsDto.of(placeNews1);

        placeNewsDtoList.add(placeNewsDto1);

        PlaceNews placeNews2 = new PlaceNews();
        placeNews2.setNews(news);
        placeNews2.setPlace(place2);
        placeNews2.setId(2L);
        PlaceNewsDto placeNewsDto2 = PlaceNewsDto.of(placeNews2);

        placeNewsDtoList.add(placeNewsDto2);

        placeNewsService.savePlaceNews(placeNewsDtoList, place1);

        AreaDto areaDto = AreaDto.of(area);

        areaDtoList.add(areaDto);

        return areaDtoList;
    }
}