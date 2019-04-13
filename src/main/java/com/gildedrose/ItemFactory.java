package com.gildedrose;

class ItemFactory {
    private static final String AGED_BRIE_ITEM = "Aged Brie";
    private static final String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured Mana Cake";

    static CustomItem createCustomItem(Item item) {
        switch (item.name) {
            case AGED_BRIE_ITEM:
                return new AgedBrieItem(item);
            case BACKSTAGE_ITEM:
                return new BackstageItem(item);
            case SULFURAS_ITEM:
                return new SulfurasItem(item);
            case CONJURED_ITEM:
                return new ConjuredItem(item);
            default:
                return new NormalItem(item);

        }
    }
}
