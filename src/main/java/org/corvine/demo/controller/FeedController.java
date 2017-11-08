package org.corvine.demo.controller;

import org.corvine.demo.domain.Item;
import org.corvine.demo.repository.FeedRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {
    private FeedRepository feedRepository;

    public FeedController(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @RequestMapping("/feed")
    public String index() {
        List<Item> items = feedRepository.findAllItems();

        return items.toString();
    }

}