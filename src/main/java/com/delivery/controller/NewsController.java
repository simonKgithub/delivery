package com.delivery.controller;

import com.delivery.dto.NewsDto;
import com.delivery.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/openNewsPopup")
    public String getOpenNewsPopup(Model model){
        List<NewsDto> newsDtoList = newsService.findAllNewspaper();

        model.addAttribute("newsDtoList", newsDtoList);

        return "news/newsPopup";
    }

    @PostMapping("/saveNews")
    @ResponseBody
    public NewsDto saveNews(@RequestBody NewsDto newsDto){
        return newsService.saveNews(newsDto);
    }

    @DeleteMapping("/deleteNews")
    @ResponseBody
    public int deleteNews(@RequestBody List<NewsDto> newsDtoList) {
        int count = 0;
        for (NewsDto newsDto : newsDtoList) {
            newsService.deleteNews(newsDto);
            count++;
        }
        return count;
    }

    @PatchMapping("/updateNews")
    @ResponseBody
    public NewsDto updateNews(@RequestBody NewsDto newsDto) {
        return newsService.updateNews(newsDto);
    }
}
