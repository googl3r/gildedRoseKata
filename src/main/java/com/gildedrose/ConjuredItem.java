package com.gildedrose;

public class ConjuredItem implements ItemStrategy {
    private Item item;

    ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateItem() {
        decreaseSelling();
        if (sellingPassed()) {
            decreaseQualityBy(4);
        } else {
            decreaseQualityBy(2);
        }

    }

    private void decreaseQualityBy(int quality) {
        item.quality = item.quality - quality;
    }

    private boolean sellingPassed() {
        return item.sellIn < 0;
    }

    private void decreaseSelling() {
        item.sellIn -= 1;
    }
}
