package com.gildedrose;

public class AgedBrieItem extends CustomItem {
    AgedBrieItem(Item item) {
        super(item);
    }
    public void update() {
        decreaseSelling();
        increaseQuality();
        if (sellingPassed()) {
            increaseQuality();
        }
    }


}
