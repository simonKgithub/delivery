package com.delivery.service;

import com.delivery.entity.Newspaper;
import com.delivery.repository.NewspaperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewspaperService {
    private final NewspaperRepository newspaperRepository;

    public List<Newspaper> findAllNewspaper() {
        return newspaperRepository.findAll();
    }
}
