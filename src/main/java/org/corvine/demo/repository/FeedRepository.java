package org.corvine.demo.repository;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedRepository {

    public List<String> findAllItems() {
        List<String> items = new ArrayList<>();

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

        return items;
    }
}