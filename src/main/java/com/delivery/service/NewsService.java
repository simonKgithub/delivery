package com.delivery.service;

import com.delivery.dto.NewsDto;
import com.delivery.entity.News;
import com.delivery.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public List<NewsDto> findAllNewspaper() {
        List<NewsDto> newsDtoList = new ArrayList<>();

        List<News> newsList = newsRepository.findAll();
        newsList.forEach(news -> {
            NewsDto newsDto = NewsDto.of(news);
            newsDtoList.add(newsDto);
        });

        return newsDtoList;
    }

    public NewsDto saveNews(NewsDto newsDto) {
        News news = new News();
        news.setNewsNm(newsDto.getNewsNm());

        News savedNews = newsRepository.save(news);

        NewsDto savedNewsDto = NewsDto.of(savedNews);

        return savedNewsDto;
    }

    public void deleteNews(NewsDto newsDto) {
        News news = new News();
        news.setNewsId(newsDto.getNewsId());

        newsRepository.delete(news);
    }

    public NewsDto updateNews(NewsDto newsDto) {
        News news = new News();
        news.setNewsId(newsDto.getNewsId());
        news.setNewsNm(newsDto.getNewsNm());
        News updatedNews = newsRepository.save(news);

        return NewsDto.of(updatedNews);
    }
}
