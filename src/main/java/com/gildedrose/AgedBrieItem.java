package com.gildedrose;

public class AgedBrieItem extends CustomItem {
    private Item item;

    AgedBrieItem(Item item) {
        super(item);
        this.item = item;
    }
    public void updateItem() {
        decreaseSelling();
        increaseQuality();
        if (sellingPassed()) {
            increaseQuality();
        }
    }

    private boolean sellingPassed() {
        return item.sellIn < 0;
    }

    private void increaseQuality() {
        item.quality += 1;
    }

    private void decreaseSelling() {
        item.sellIn -= 1;
    }
}
