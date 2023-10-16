package com.delivery.dto;

import com.delivery.entity.News;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter @Setter @ToString
public class NewsDto {
    private Long newsId;

    private String newsNm;

    private static ModelMapper modelMapper = new ModelMapper();

    public static NewsDto of(News news) {
        return modelMapper.map(news, NewsDto.class);
    }
}
