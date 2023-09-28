package com.delivery.service;

import com.delivery.dto.PlaceFormDto;
import com.delivery.entity.Place;
import com.delivery.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public Place savePlace(PlaceFormDto placeFormDto){
        Place place = new Place();

        return placeRepository.save(place);
    }
}
