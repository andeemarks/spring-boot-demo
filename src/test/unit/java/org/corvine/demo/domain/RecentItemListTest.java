package org.corvine.demo.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecentItemListTest {
    @Test
    public void itemsCanBeAddedToList() {
        RecentItemList list = new RecentItemList();
        Item newItem = new Item("MSS 56918 | VOX V847-A", "<p>Filed under: Stomp Boxes</p><p>Voltage Doubled FET Preamp. Dual FETs for the most tube like tone in a transistor design. <br>With the speed knob Pushed In, think of it as a volume control that goes to 20. <br>With the speed knob Pulled Out, it’s a cutting boost with a bit of gain. Not quite an overdrive, just overdriven tube grit and edge to your tone.<br>Includes box<br />Price: $225.00<a href=\"http://www.musicswopshop.com.au/stock?search=MSS 56958\"><br />Read more ...</a></p> ", "link");
        list = list.add(newItem);

        assertEquals(newItem, list.get(0));
    }

    @Test
    public void listIsMaintainedInReverseIdOrder() {
        RecentItemList list = new RecentItemList();
        Item first = new Item("MSS 56918 | VOX V847-A", "<p>Filed under: Stomp Boxes</p><p>Voltage Doubled FET Preamp. Dual FETs for the most tube like tone in a transistor design. <br>With the speed knob Pushed In, think of it as a volume control that goes to 20. <br>With the speed knob Pulled Out, it’s a cutting boost with a bit of gain. Not quite an overdrive, just overdriven tube grit and edge to your tone.<br>Includes box<br />Price: $225.00<a href=\"http://www.musicswopshop.com.au/stock?search=MSS 56958\"><br />Read more ...</a></p> ", "link");
        Item second = new Item("MSS 56919 | VOX V847-A", "<p>Filed under: Stomp Boxes</p><p>Voltage Doubled FET Preamp. Dual FETs for the most tube like tone in a transistor design. <br>With the speed knob Pushed In, think of it as a volume control that goes to 20. <br>With the speed knob Pulled Out, it’s a cutting boost with a bit of gain. Not quite an overdrive, just overdriven tube grit and edge to your tone.<br>Includes box<br />Price: $225.00<a href=\"http://www.musicswopshop.com.au/stock?search=MSS 56958\"><br />Read more ...</a></p> ", "link");
        Item third = new Item("MSS 56920 | VOX V847-A", "<p>Filed under: Stomp Boxes</p><p>Voltage Doubled FET Preamp. Dual FETs for the most tube like tone in a transistor design. <br>With the speed knob Pushed In, think of it as a volume control that goes to 20. <br>With the speed knob Pulled Out, it’s a cutting boost with a bit of gain. Not quite an overdrive, just overdriven tube grit and edge to your tone.<br>Includes box<br />Price: $225.00<a href=\"http://www.musicswopshop.com.au/stock?search=MSS 56958\"><br />Read more ...</a></p> ", "link");
        list = list.add(second);
        list = list.add(third);
        list = list.add(first);

        assertEquals(third, list.get(0));
        assertEquals(second, list.get(1));
        assertEquals(first, list.get(2));
    }

}