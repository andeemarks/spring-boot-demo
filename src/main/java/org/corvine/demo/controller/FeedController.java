package org.corvine.demo.controller;

import org.corvine.demo.domain.Item;
import org.corvine.demo.repository.FeedRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FeedController {
    private FeedRepository feedRepository;

    public FeedController(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @RequestMapping("/feed")
    public String feed(Model model) {
        List<Item> items = feedRepository.findAllItems();

        model.addAttribute("name", "Andy");
        model.addAttribute("items", items);

        return "feed";
    }

}