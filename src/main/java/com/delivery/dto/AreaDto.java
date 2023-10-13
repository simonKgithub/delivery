package com.delivery.dto;

import com.delivery.entity.Area;
import com.delivery.entity.PlaceNews;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter @Setter @ToString
public class AreaDto {
    private Long areaId;

    private String areaNm;

    private String areaManager;

    private static ModelMapper modelMapper = new ModelMapper();

    public static AreaDto of(Area area) {
        return modelMapper.map(area, AreaDto.class);
    }
}
