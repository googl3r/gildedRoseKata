package com.gildedrose;

class GildedRose {
    private static final int HIGHEST_QUALITY = 50;
    private static final int LOWEST_QUALITY = 0;
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {

            if (itemCanBeUpdated(item)) {
                updateItem(item);
            }
        }
    }

    private void updateItem(Item item) {
        ItemFactory.createItem(item).updateItem();
    }

    private boolean itemCanBeUpdated(Item item) {
        return item.quality < HIGHEST_QUALITY && item.quality > LOWEST_QUALITY;
    }
}