package com.gildedrose;

public abstract class CustomItem {
    private static final int HIGHEST_QUALITY = 50;
    private static final int LOWEST_QUALITY = 0;
    protected Item item;

    CustomItem(Item item) {
        this.item = item;
    }
    protected boolean canBeUpdated() {
        return item.quality < HIGHEST_QUALITY && item.quality > LOWEST_QUALITY;
    }
    protected abstract void update();

     protected void decreaseSelling() {
        item.sellIn -= 1;
    }
    protected void increaseQuality() {
        item.quality += 1;
    }
    protected boolean sellingPassed() {
        return item.sellIn < 0;
    }
}
