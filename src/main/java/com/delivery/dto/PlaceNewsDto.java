package com.delivery.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PlaceNewsDto {
    private String placeNewsNm;

    private String placeNewsDesc;

    private int placeNewsCount;

    private Long placeId;

    private Long newsId;
}
