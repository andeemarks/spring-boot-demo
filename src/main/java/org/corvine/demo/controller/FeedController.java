package org.corvine.demo.controller;

import org.corvine.demo.domain.RecentItemList;
import org.corvine.demo.repository.FeedRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class FeedController {
    private FeedRepository feedRepository;

    public FeedController(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @RequestMapping("/feed")
    public ModelAndView feed(Map<String, Object> model) {
        RecentItemList list = feedRepository.findAllItems();

        model.put("name", "Andy");
        model.put("items", list.getItems());

        return new ModelAndView("feed", model);
    }

}