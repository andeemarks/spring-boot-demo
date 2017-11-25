package org.corvine.demo.repository;

import org.corvine.demo.domain.RecentItemList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedRepositoryIntegrationTest {

    @Autowired
    private FeedRepository repository;

    @Test
    public void feedListShouldShowItems() throws Exception {
        RecentItemList list = repository.findAllItems();
        assertTrue("Not enough items found: " + list.getItems().size(), list.getItems().size() > 0);
    }
}