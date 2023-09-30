package com.delivery.dto;

import com.delivery.entity.Newspaper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
public class PlaceFormDto {
    private String xPoint;

    private String yPoint;

    private String placeNm;

    private String placeDesc;

    private int deliveryOrder;

    private List<NewspaperFormDto> newspaperFormDtoList = new ArrayList<>();
}
