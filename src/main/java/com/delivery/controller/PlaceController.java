package com.delivery.controller;

import com.delivery.dto.PlaceNewsDto;
import com.delivery.dto.PlaceDto;
import com.delivery.entity.News;
import com.delivery.entity.Place;
import com.delivery.entity.PlaceNews;
import com.delivery.service.NewsService;
import com.delivery.service.PlaceNewsService;
import com.delivery.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final PlaceNewsService placeNewsService;
    private final NewsService newsService;

    @GetMapping("/openNewsPopup")
    public String getOpenNewsPopup(Model model){
        List<News> newsList = newsService.findAllNewspaper();

        model.addAttribute("newsList", newsList);

        return "place/newsPopup";
    }

    @GetMapping("/new")
    public String getPlaceForm() {
        return "place/placeForm";
    }

    @Transactional
    @PostMapping("/new")
    public String postPlaceForm(PlaceDto placeDto, Model model) {
        //유효성 체크 필요

        // 장소 저장
        Place newPlace = placeService.savePlace(placeDto);
        // 신문 저장
        placeNewsService.savePlaceNews(placeDto.getPlaceNewsDtoList(), newPlace);

        List<PlaceDto> placeDtoList = placeService.findAllPlaces();
//        List<PlaceNews> placeNewsList = placeNewsService.findAllNewspaper();

        model.addAttribute("placeDtoList", placeDtoList);
//        model.addAttribute("placeNewsList", placeNewsList);

        return "/place/list";
    }
}
