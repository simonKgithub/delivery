package com.delivery.service;

import com.delivery.constant.DeliveryStatus;
import com.delivery.dto.PlaceDto;
import com.delivery.entity.Place;
import com.delivery.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public Place savePlace(PlaceDto placeDto){
        Place place = new Place();

        place.setXPoint(placeDto.getXPoint());
        place.setYPoint(placeDto.getYPoint());
        place.setPlaceNm(placeDto.getPlaceNm());
        place.setPlaceDesc(place.getPlaceDesc());
        place.setDeliveryOrder(placeDto.getDeliveryOrder());
        place.setDeliveryStatus(DeliveryStatus.Y);
        place.setRegTime(LocalDateTime.now());

        return placeRepository.save(place);
    }

    public List<PlaceDto> findAllPlaces() {
        List<Place> placeList = placeRepository.findAll();
        List<PlaceDto> placeDtoList = new ArrayList<>();
        for (Place place : placeList) {
            PlaceDto newPlaceDto = PlaceDto.of(place);
            placeDtoList.add(newPlaceDto);
        }
        return placeDtoList;
    }
}
