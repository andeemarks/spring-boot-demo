package org.corvine.demo.controller;

import org.corvine.demo.domain.Item;
import org.corvine.demo.repository.FeedRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class FeedController {
    private FeedRepository feedRepository;

    public FeedController(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @RequestMapping("/feed")
    public ModelAndView feed(Map<String, Object> model) {
        List<Item> items = feedRepository.findAllItems();

        model.put("name", "Andy");
        model.put("items", items);

        return new ModelAndView("feed", model);
    }

}