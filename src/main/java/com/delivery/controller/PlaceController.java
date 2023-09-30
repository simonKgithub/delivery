package com.delivery.controller;

import com.delivery.dto.NewspaperFormDto;
import com.delivery.dto.PlaceFormDto;
import com.delivery.entity.Newspaper;
import com.delivery.service.NewspaperService;
import com.delivery.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final NewspaperService newspaperService;

    @GetMapping("/openNewspaperPopup")
    public String getOpenNewspaperPopup(Model model){

        List<Newspaper> newspaperList = newspaperService.findAllNewspaper();

        model.addAttribute("newspaperList", newspaperList);

        return "place/newspaperPopup";
    }

    @GetMapping("/new")
    public String getPlaceForm(Model model) {
        List<NewspaperFormDto> newspaperFormDtoList = new ArrayList<>();
        model.addAttribute("placeFormDto", new PlaceFormDto());
        model.addAttribute("newspaperFormDtoList", newspaperFormDtoList);
        return "place/placeForm";
    }

    @PostMapping("/new")
    public String postPlaceForm(PlaceFormDto placeFormDto, Model model) {
        System.out.println(placeFormDto.toString());
        return "place/placeForm";
    }
}
