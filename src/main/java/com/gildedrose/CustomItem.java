package com.gildedrose;

public abstract class CustomItem {
    private static final int HIGHEST_QUALITY = 50;
    private static final int LOWEST_QUALITY = 0;
    private Item item;

    CustomItem(Item item) {
        this.item = item;
    }
    boolean canBeUpdated() {
        return item.quality < HIGHEST_QUALITY && item.quality > LOWEST_QUALITY;
    }
    public abstract void updateItem();
}
