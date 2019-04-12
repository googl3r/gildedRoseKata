package com.gildedrose;

public class NormalItem implements ItemStrategy {
    private Item item;

    NormalItem(Item item) {
        this.item = item;
    }
    public void updateItem() {
        decreaseSelling();
        if (sellingPassed()) {
            decreaseQualityBy(2);
        } else {
            decreaseQualityBy(1);
        }
    }

    private boolean sellingPassed() {
        return item.sellIn < 0;
    }

    private void decreaseSelling() {
        item.sellIn -= 1;
    }
    private void decreaseQualityBy(int quality) {
        item.quality = item.quality - quality;
    }
}
