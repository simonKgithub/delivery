package com.delivery.dto;

import com.delivery.entity.Place;
import com.delivery.entity.PlaceNews;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter @Setter @ToString
public class PlaceNewsDto {
    private String placeNewsNm;

    private String placeNewsDesc;

    private int placeNewsCount;

    private Long placeId;

    private Long newsId;

    private static ModelMapper modelMapper = new ModelMapper();

    public static PlaceNewsDto of(PlaceNews placeNews) {
        return modelMapper.map(placeNews, PlaceNewsDto.class);
    }
}
