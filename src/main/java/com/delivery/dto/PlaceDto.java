package com.delivery.dto;

import com.delivery.constant.DeliveryStatus;
import com.delivery.entity.Place;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
public class PlaceDto {
    private String id;

    private String xPoint;

    private String yPoint;

    private String placeNm;

    private String placeDesc;

    private int deliveryOrder;

    private DeliveryStatus deliveryStatus;

    private List<PlaceNewsDto> placeNewsDtoList = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public static PlaceDto of(Place place) {
        return modelMapper.map(place, PlaceDto.class);
    }
}
