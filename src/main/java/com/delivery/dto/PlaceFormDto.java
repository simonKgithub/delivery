package com.delivery.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PlaceFormDto {
    private String address;

    private String placeNm;

    private String placeDesc;

    private int orderNum;
}
