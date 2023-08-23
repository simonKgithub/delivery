package com.delivery.service;

import com.delivery.dto.PlaceFormDto;
import com.delivery.entity.Place;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional //테스트에서 선언할 경우 테스트 종료 후 rollback 됨
@TestPropertySource(locations = "classpath:application-test.properties")
class PlaceServiceTest {

    @Autowired
    PlaceService placeService;

    @Test
    @DisplayName("장소 저장 테스트")
    public void savePlaceTest(){
        PlaceFormDto placeFormDto = new PlaceFormDto();
        placeFormDto.setAddress("테스트주소");
        placeFormDto.setPlaceNm("테스트장소");
        placeFormDto.setPlaceDesc("테스트설명");

        placeFormDto.setOrderNum(1);

        Place place = placeService.savePlace(placeFormDto);

        assertEquals(place.getAddress(), placeFormDto.getAddress());
        assertEquals(place.getPlaceNm(), placeFormDto.getPlaceNm());
        assertEquals(place.getPlaceDesc(), placeFormDto.getPlaceDesc());
        assertEquals(place.getOrderNum(), placeFormDto.getOrderNum());
    }
}