package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GildedRoseLegacyCodeTest {


    @Test
    void givenTwoArraysWithTheSameValues_whenCallTheOldAndNewVersionGildedRose_thenTheValuesAreEquals() {

        Item[] itemsVersion1 = getItems();
        GildedRose gildedRoseVersion1 = new GildedRose(itemsVersion1);
        Item[] itemsVersion2 = getItems();
        com.gildedrose.gildedrose.v2.GildedRose gildedRoseVersion2 = new com.gildedrose.gildedrose.v2.GildedRose(itemsVersion2);
        int daysAmount = 11;

        for (int day = 0; day < daysAmount; day++) {
            for (int itemIndex = 0; itemIndex < itemsVersion1.length; itemIndex++) {
                Assertions.assertEquals(itemsVersion1[itemIndex].sellIn, itemsVersion2[itemIndex].sellIn);
                Assertions.assertEquals(itemsVersion1[itemIndex].quality, itemsVersion2[itemIndex].quality);
            }
            gildedRoseVersion1.updateQuality();
            gildedRoseVersion2.updateQuality();
        }
    }

    private static Item[] getItems() {
        return new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
    }

}
