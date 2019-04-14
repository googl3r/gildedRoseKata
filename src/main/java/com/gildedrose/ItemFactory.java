package com.gildedrose;

class ItemFactory {
    private static final String AGED_BRIE_ITEM = "Aged Brie";
    private static final String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured Mana Cake";

    static FinestGood createFinestGood(Item item) {
        switch (item.name) {
            case AGED_BRIE_ITEM:
                return new AgedBrie(item);
            case BACKSTAGE_ITEM:
                return new Backstage(item);
            case SULFURAS_ITEM:
                return new Sulfuras(item);
            case CONJURED_ITEM:
                return new Conjured(item);
            default:
                return new Normal(item);

        }
    }
}
