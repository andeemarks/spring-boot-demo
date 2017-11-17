package org.corvine.demo.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void shouldBeAbleToParseDescriptionFieldsOnConstruction() {
        Item item = new Item("MSS 56918 | VOX V847-A", "<p>Filed under: Solid State Combos</p><p>Made japan. Vintage 60 watt 1x12\" with overdrive & reverb!<br />Price: $380.00<a href=\"http://www.musicswopshop.com.au/stock?search=MSS 56874\"><br />Read more ...</a></p>", "link");

        assertEquals("Solid State Combos", item.getCategory());
        assertEquals("Made japan. Vintage 60 watt 1x12\" with overdrive & reverb!", item.getBlurb());
        assertEquals("$380.00", item.getPrice());
        assertEquals("http://www.musicswopshop.com.au/stock?search=MSS 56874", item.getUrl());
    }
    @Test
    public void shouldBeAbleToParseLongerDescriptionFieldsOnConstruction() {
        Item item = new Item("MSS 56918 | VOX V847-A", "<p>Filed under: Stomp Boxes</p><p>Voltage Doubled FET Preamp. Dual FETs for the most tube like tone in a transistor design. <br> With the speed knob Pushed In, think of it as a volume control that goes to 20. <br> With the speed knob Pulled Out, it’s a cutting boost with a bit of gain. Not quite an overdrive, just overdriven tube grit and edge to your tone.<br> Includes box<br />Price: $225.00<a href=\"http://www.musicswopshop.com.au/stock?search=MSS 56958\"><br />Read more ...</a></p>", "link");

        assertEquals("Stomp Boxes", item.getCategory());
        assertEquals("Voltage Doubled FET Preamp. Dual FETs for the most tube like tone in a transistor design. <br> With the speed knob Pushed In, think of it as a volume control that goes to 20. <br> With the speed knob Pulled Out, it’s a cutting boost with a bit of gain. Not quite an overdrive, just overdriven tube grit and edge to your tone.<br> Includes box", item.getBlurb());
        assertEquals("$225.00", item.getPrice());
        assertEquals("http://www.musicswopshop.com.au/stock?search=MSS 56958", item.getUrl());
    }

    @Test
    public void shouldBeAbleToParseTitleFieldsOnConstruction() {
        Item item = new Item("MSS 56918 | VOX V847-A", "<p>Filed under: Solid State Combos</p><p>Made japan. Vintage 60 watt 1x12\" with overdrive & reverb!<br />Price: $380.00<a href=\"http://www.musicswopshop.com.au/stock?search=MSS 56874\"><br />Read more ...</a></p>", "link");

        assertEquals("MSS 56918", item.getId());
        assertEquals("VOX V847-A", item.getTitle());
    }
}
