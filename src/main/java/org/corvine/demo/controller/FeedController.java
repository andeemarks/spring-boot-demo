package org.corvine.demo.controller;

import com.rometools.rome.feed.synd.SyndEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeedController {
    private static final Logger log = LoggerFactory.getLogger(FeedController.class);

    @RequestMapping("/feed")
    public String index() {
        List<String> items = new ArrayList<>();
        loadItems(items);

        return items.toString();
    }

    private void loadItems(List<String> items) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/feed/swoppy.xml");

        PollableChannel feedChannel = context.getBean("swoppyFeed", PollableChannel.class);

        Message<SyndEntry> message;
        do {
            //noinspection unchecked
            message = (Message<SyndEntry>) feedChannel.receive(3000);
            if (message != null) {
                SyndEntry entry = message.getPayload();
                items.add(entry.getTitle());
            }
        } while (message != null);
    }

}