package com.delivery.controller;

import com.delivery.dto.AreaDto;
import com.delivery.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/area")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @GetMapping("/list")
    public String getAreaList(Model model) {
        List<AreaDto> areaDtoList = areaService.findAll();

        model.addAttribute("areaDtoList", areaDtoList);

        return "area/list";
    }

    @PostMapping("/new")
    @ResponseBody
    public AreaDto newAreaAddAjax(@RequestBody AreaDto areaDto){
        return areaService.save(areaDto);
    }

    @DeleteMapping("/delete")
    public void deleteAreaAjax(@RequestBody List<AreaDto> areaDtoList) {
        System.out.println("areaDtoList = " + areaDtoList);
    }
}
