package com.gildedrose;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GildedRoseTest {
    private Item[] items;
    private GildedRose gildedRose;

    @BeforeEach
    void setup() {
        items = new Item[1];
    }

    @Nested
    class NormalItem {
        int INITIAL_QUALITY = 3;
        int QUALITY_DECREASED_ONCE = 2;
        int QUALITY_DECREASED_TWICE = 1;

        private Item onGoingSellingItem = new Item("MacBook Pro", 10, INITIAL_QUALITY);
        private Item passedSellDayItem = new Item("MacBook Pro", 0, INITIAL_QUALITY);

        @Test
        void updateAnItemQuality() {
            items[0] = onGoingSellingItem;
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityDecreased(QUALITY_DECREASED_ONCE, getQuality(onGoingSellingItem));
        }

        @Test
        void updateAnItemQualityWhenSellDayPassed() {
            items[0] = passedSellDayItem;
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityDecreased(QUALITY_DECREASED_TWICE, getQuality(passedSellDayItem));
        }

    }

    @Nested
    class AgedBrieItem {
        private static final int INITIAL_ITEM_QUALITY = 10;
        private static final int INCREASE_ONCE_ITEM_QUALITY = 11;
        private static final int INCREASE_TWICE_ITEM_QUALITY = 12;

        private Item onGoingSellDayAgedBrieItem =
                new Item("Aged Brie", 5, INITIAL_ITEM_QUALITY);
        private Item passedSellDayAgedBrieItem =
                new Item("Aged Brie", 0, INITIAL_ITEM_QUALITY);

        @Test
        void updateAgedBrieItemQuality() {
            items[0] = onGoingSellDayAgedBrieItem;
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityIncreased(INCREASE_ONCE_ITEM_QUALITY, getQuality(onGoingSellDayAgedBrieItem));
        }

        @Test
        void updateAgedBrieItemWhenSellDayPassed() {
            items[0] = passedSellDayAgedBrieItem;
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityIncreased(INCREASE_TWICE_ITEM_QUALITY, getQuality(passedSellDayAgedBrieItem));
        }
    }

    @Nested
    class BackStageItem {
        private static final int INITIAL_ITEM_QUALITY = 10;
        private static final int INCREASE_ITEM_QUALITY_TWICE = 12;
        private static final int INCREASE_ITEM_QUALITY_THRICE = 13;
        private static final int RESET_ITEM_QUALITY = 0;

        private Item backStageSellingItemIn10Days = new Item("Backstage passes to a TAFKAL80ETC concert",
                10, INITIAL_ITEM_QUALITY);
        private Item backStageSellingIn5Days = new Item("Backstage passes to a TAFKAL80ETC concert",
                5, INITIAL_ITEM_QUALITY);
        private Item passedSellDayBackStageItem = new Item("Backstage passes to a TAFKAL80ETC concert",
                0, INITIAL_ITEM_QUALITY);

        @Test
        void updateBackStageItemQualityWhenSellingIn10days() {
            items[0] = backStageSellingItemIn10Days;
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityIncreased(INCREASE_ITEM_QUALITY_TWICE, getQuality(backStageSellingItemIn10Days));
        }

        @Test
        void updateBackStageItemQualityWhenSellingIn5Days() {
            items[0] = backStageSellingIn5Days;
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityIncreased(INCREASE_ITEM_QUALITY_THRICE, getQuality(backStageSellingIn5Days));
        }

        @Test
        void updateBackStageItemWhenSellingDayPassed() {
            items[0] = passedSellDayBackStageItem;
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityIncreased(RESET_ITEM_QUALITY, getQuality(passedSellDayBackStageItem));
        }
    }

    @Nested
    class SulfurasItem {
        private static final int SULFURAS_ITEM_QUALITY = 5;
        private Item surlfurasItem = new Item("Sulfuras, Hand of Ragnaros", 5,
                SULFURAS_ITEM_QUALITY);

        @Test
        void updateSulfurasItemQuality() {
            items[0] = surlfurasItem;
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityIsSame(getQuality(surlfurasItem));
        }

        private void assertItemQualityIsSame(int expectedQuality) {
            Assertions.assertEquals(SULFURAS_ITEM_QUALITY, expectedQuality);
        }

    }

    @Nested
    class ConjuredItem {

        @Test
        void updateQuality() {
            items[0] = new Item("Conjured Mana Cake", 10, 10);
            gildedRose = new GildedRose(items);
            gildedRose.updateQuality();
            assertItemQualityDecreased(8, getQuality(items[0]));

        }

    }

    private void assertItemQualityIncreased(int expectedQuality, int currentQuality) {
        Assertions.assertEquals(expectedQuality, currentQuality);
    }
    private void assertItemQualityDecreased(int expectedQuality, int currentQuality) {
        Assertions.assertEquals(expectedQuality, currentQuality);
    }

    private int getQuality(Item item) {
        return item.quality;
    }


}
