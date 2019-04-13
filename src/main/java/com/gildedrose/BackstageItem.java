package com.gildedrose;

public class BackstageItem extends CustomItem {

    BackstageItem(Item item) {
        super(item);
    }

    public void update() {
        decreaseSellIn();
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


    private void decreaseSellIn() {
        item.sellIn -= 1;
    }
}
