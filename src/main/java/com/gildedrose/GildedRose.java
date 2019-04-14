package com.gildedrose;

class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            FinestGood finestGood = ItemFactory.createFinestGood(item);
            if (finestGood.canBeUpdated()) {
                finestGood.update();
            }
        }
    }
}