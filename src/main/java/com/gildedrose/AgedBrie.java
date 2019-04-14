package com.gildedrose;

public class AgedBrie extends FinestGood {
    AgedBrie(Item item) {
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
