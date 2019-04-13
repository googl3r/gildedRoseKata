package com.gildedrose;

public class ConjuredItem extends CustomItem {

    ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
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

}
