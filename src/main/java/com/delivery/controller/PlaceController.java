package com.delivery.controller;

import com.delivery.dto.PlaceDto;
import com.delivery.entity.News;
import com.delivery.entity.Place;
import com.delivery.service.NewsService;
import com.delivery.service.PlaceNewsService;
import com.delivery.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final PlaceNewsService placeNewsService;

    @GetMapping("/list/{areaId}")
    public String getPlaceList(@PathVariable("areaId") Long areaId, Model model){

        List<PlaceDto> placeDtoList = placeService.findPlacesWithNews(areaId);
        model.addAttribute("placeDtoList", placeDtoList);

        return "place/list";
    }

    @GetMapping("/new/{areaId}")
    public String getPlaceForm(@PathVariable("areaId") Long areaId) {
        return "place/placeForm";
    }

    @Transactional
    @PostMapping("/new")
    public String postPlaceForm(PlaceDto placeDto) {
        //유효성 체크 필요

        // 장소 저장 및 신문 저장
        Place newPlace = placeService.savePlace(placeDto);
        placeNewsService.savePlaceNews(placeDto.getPlaceNewsDtoList(), newPlace);

        Long areaId = newPlace.getArea().getAreaId();

        return "redirect:list/" + areaId;
    }
}
