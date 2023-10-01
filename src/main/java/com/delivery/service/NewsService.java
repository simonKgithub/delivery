package com.delivery.service;

import com.delivery.entity.News;
import com.delivery.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public List<News> findAllNewspaper() {
        return newsRepository.findAll();
    }
}
