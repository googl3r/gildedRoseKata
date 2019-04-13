package com.gildedrose;

public class NormalItem extends CustomItem {

    NormalItem(Item item) {
        super(item);
    }
    public void update() {
        decreaseSelling();
        if (sellingPassed()) {
            decreaseQualityBy(2);
        } else {
            decreaseQualityBy(1);
        }
    }
    private void decreaseQualityBy(int quality) {
        item.quality = item.quality - quality;
    }
}
