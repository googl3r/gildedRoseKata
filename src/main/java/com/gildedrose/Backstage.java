package com.gildedrose;

public class Backstage extends FinestGood {

    Backstage(Item item) {
        super(item);
    }

    public void update() {
        decreaseSelling();
        increaseQuality();
        if (sellingIn11Days() && canBeUpdated()) {
            increaseQuality();
        }
        if (sellingIn6Days()) {
            increaseQuality();
        }
        if (sellingPassed()) {
            resetQuality();
        }
    }

    private void resetQuality() {
        item.quality = 0;
    }


    private boolean sellingIn6Days() {
        return item.sellIn < 6;
    }

    private boolean sellingIn11Days() {
        return item.sellIn < 11;
    }
}
