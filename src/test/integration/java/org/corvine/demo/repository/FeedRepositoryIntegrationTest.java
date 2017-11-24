package org.corvine.demo.repository;

import org.corvine.demo.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedRepositoryIntegrationTest {

    @Autowired
    private FeedRepository repository;

    @Test
    public void feedListShouldShowItems() throws Exception {
        List<Item> items = repository.findAllItems();
        assertTrue("Not enough items found: " + items.size(), items.size() > 0);
    }
}