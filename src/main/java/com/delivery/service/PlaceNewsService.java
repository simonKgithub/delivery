package com.delivery.service;

import com.delivery.dto.PlaceDto;
import com.delivery.dto.PlaceNewsDto;
import com.delivery.entity.News;
import com.delivery.entity.Place;
import com.delivery.entity.PlaceNews;
import com.delivery.repository.NewsRepository;
import com.delivery.repository.PlaceNewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceNewsService {
    private final PlaceNewsRepository placeNewsRepository;
    private final NewsRepository newsRepository;

    public List<PlaceNews> findAllPlaceNews() {
        return placeNewsRepository.findAll();
    }

    public void savePlaceNews(List<PlaceNewsDto> placeNewsDtoList, Place place) {
        for (PlaceNewsDto placeNewsDto : placeNewsDtoList) {
            PlaceNews placeNews = new PlaceNews();

            Long newsId = placeNewsDto.getNewsId();

            News news = newsRepository.findById(newsId).orElseThrow(EntityNotFoundException::new);

            placeNews.setPlaceNewsNm(placeNewsDto.getPlaceNewsNm());
            placeNews.setPlaceNewsDesc(placeNewsDto.getPlaceNewsDesc());
            placeNews.setPlaceNewsCount(placeNewsDto.getPlaceNewsCount());
            placeNews.setNews(news);
            placeNews.setPlace(place);

            placeNewsRepository.save(placeNews);
        }
    }

    public List<PlaceNews> findByPlace(Place place) {
        return placeNewsRepository.findByPlace(place);
    }

    public void deletePlaceNews(PlaceNews placeNews) {
        placeNewsRepository.delete(placeNews);
    }
}
