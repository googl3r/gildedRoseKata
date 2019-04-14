package com.gildedrose;

public class Conjured extends FinestGood {

    Conjured(Item item) {
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
