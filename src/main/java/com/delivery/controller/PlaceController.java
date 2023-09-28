package com.delivery.controller;

import com.delivery.dto.NewspaperFormDto;
import com.delivery.dto.PlaceFormDto;
import com.delivery.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/new")
    public String placeForm(Model model) {
        model.addAttribute("placeFormDto", new PlaceFormDto());
        model.addAttribute("newspaperFormDto", new NewspaperFormDto());
        return "place/placeForm";
    }
}
