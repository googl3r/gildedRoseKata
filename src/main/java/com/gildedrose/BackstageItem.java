package com.gildedrose;

public class BackstageItem extends CustomItem {
    private Item item;

    BackstageItem(Item item) {
        super(item);
        this.item = item;
    }

    public void updateItem() {
        decreaseSellIn();
        increaseQuality();
        if (sellingIn11Days() && qualityCanBeIncreased()) {
            increaseQuality();
        }
        if (sellingIn6Days()) {
            increaseQuality();
        }
        if (sellingPassed()) {
            resetQuality();
        }
    }
    private boolean qualityCanBeIncreased() {
        return item.quality < 50;
    }

    private void resetQuality() {
        item.quality = 0;
    }

    private boolean sellingPassed() {
        return item.sellIn < 0;
    }

    private boolean sellingIn6Days() {
        return item.sellIn < 6;
    }

    private boolean sellingIn11Days() {
        return item.sellIn < 11;
    }

    private void increaseQuality() {
        item.quality += 1;
    }

    private void decreaseSellIn() {
        item.sellIn -= 1;
    }
}
