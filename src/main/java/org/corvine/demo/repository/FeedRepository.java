package org.corvine.demo.repository;

import com.rometools.rome.feed.synd.SyndEntry;
import org.corvine.demo.domain.Item;
import org.corvine.demo.domain.RecentItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Repository;

@Repository
public class FeedRepository {
    private static final Logger log = LoggerFactory.getLogger(FeedRepository.class);

    @Cacheable("items")
    public RecentItemList findAllItems() {
        RecentItemList items = new RecentItemList();

        ApplicationContext context = new ClassPathXmlApplicationContext("/feed/swoppy.xml");

        PollableChannel feedChannel = context.getBean("swoppyFeed", PollableChannel.class);

        Message<SyndEntry> message;
        do {
            //noinspection unchecked
            message = (Message<SyndEntry>) feedChannel.receive(3000);
            if (message != null) {
                SyndEntry entry = message.getPayload();
                items.add(new Item(entry.getTitle(), entry.getDescription().getValue(), entry.getLink()));
            }
        } while (message != null);

        return items;
    }
}