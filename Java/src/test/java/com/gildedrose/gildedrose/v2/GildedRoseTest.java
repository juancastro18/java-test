package com.gildedrose.gildedrose.v2;


import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void givenADefaultItem_whenCallUpdateQualityWithSellInMayorOne_thenLessOneInNumericValues() {
        Item defaultItem = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose app = new GildedRose(new Item[]{defaultItem});

        app.updateQuality();

        assertEquals("+5 Dexterity Vest", defaultItem.name);
        assertEquals(9, defaultItem.sellIn);
        assertEquals(19, defaultItem.quality);
    }

    @Test
    void givenADefaultItem_whenCallUpdateQualityWithSellInZero_thenLessOneSellInAndTwoInQuality() {
        Item defaultItem = new Item("+5 Dexterity Vest", 0, 20);
        GildedRose app = new GildedRose(new Item[]{defaultItem});

        app.updateQuality();

        assertEquals("+5 Dexterity Vest", defaultItem.name);
        assertEquals(-1, defaultItem.sellIn);
        assertEquals(18, defaultItem.quality);
    }

    @Test
    void givenADefaultItem_whenCallUpdateQualityWithSellInNegative_thenLessOneSellInAndTwoInQuality() {
        Item defaultItem = new Item("+5 Dexterity Vest", -1, 20);
        GildedRose app = new GildedRose(new Item[]{defaultItem});

        app.updateQuality();

        assertEquals("+5 Dexterity Vest", defaultItem.name);
        assertEquals(-2, defaultItem.sellIn);
        assertEquals(18, defaultItem.quality);
    }

    @Test
    void givenADefaultItem_whenCallUpdateQualityWithSellInNegativeAndQualityLimit_thenLessOneSellInAndQualityZero() {
        Item defaultItem = new Item("+5 Dexterity Vest", -1, 2);
        GildedRose app = new GildedRose(new Item[]{defaultItem});

        app.updateQuality();

        assertEquals("+5 Dexterity Vest", defaultItem.name);
        assertEquals(-2, defaultItem.sellIn);
        assertEquals(0, defaultItem.quality);
    }

    @Test
    void givenADefaultItem_whenCallUpdateQualityWithSellInMayorZeroAndQualityLimit_thenLessOneSellInAndQualityZero() {
        Item defaultItem = new Item("+5 Dexterity Vest", 1, 0);
        GildedRose app = new GildedRose(new Item[]{defaultItem});

        app.updateQuality();

        assertEquals("+5 Dexterity Vest", defaultItem.name);
        assertEquals(0, defaultItem.sellIn);
        assertEquals(0, defaultItem.quality);
    }

    @Test
    void givenAnAgedBrieItem_whenCallUpdateQualityWithSellInMayorOne_thenLessOneInSellInAndOnePlusInQuality() {
        Item agedBrieItem = new Item("Aged Brie", 2, 0);
        GildedRose app = new GildedRose(new Item[]{agedBrieItem});

        app.updateQuality();

        assertEquals("Aged Brie", agedBrieItem.name);
        assertEquals(1, agedBrieItem.sellIn);
        assertEquals(1, agedBrieItem.quality);
    }

    @Test
    void givenAnAgedBrieItem_whenCallUpdateQualityWithSellInZero_thenLessOneInSellInAndTwoPlusInQuality() {
        Item agedBrieItem = new Item("Aged Brie", 0, 0);
        GildedRose app = new GildedRose(new Item[]{agedBrieItem});

        app.updateQuality();

        assertEquals("Aged Brie", agedBrieItem.name);
        assertEquals(-1, agedBrieItem.sellIn);
        assertEquals(2, agedBrieItem.quality);
    }

    @Test
    void givenAnAgedBrieItem_whenCallUpdateQualityWithSellInNegative_thenLessOneInSellInAndTwoPlusInQuality() {
        Item agedBrieItem = new Item("Aged Brie", -1, 0);
        GildedRose app = new GildedRose(new Item[]{agedBrieItem});

        app.updateQuality();

        assertEquals("Aged Brie", agedBrieItem.name);
        assertEquals(-2, agedBrieItem.sellIn);
        assertEquals(2, agedBrieItem.quality);
    }

    @Test
    void givenAnAgedBrieItem_whenCallUpdateQualityWithSellMayorZeroAndQualityLimit_thenLessOneInSellInAndQualityLimit() {
        Item agedBrieItem = new Item("Aged Brie", 1, 50);
        GildedRose app = new GildedRose(new Item[]{agedBrieItem});

        app.updateQuality();

        assertEquals("Aged Brie", agedBrieItem.name);
        assertEquals(0, agedBrieItem.sellIn);
        assertEquals(50, agedBrieItem.quality);
    }

    @Test
    void givenAnAgedBrieItem_whenCallUpdateQualityWithSellZeroAndQualityLimit_thenLessOneInSellInAndQualityLimit() {
        Item agedBrieItem = new Item("Aged Brie", 0, 49);
        GildedRose app = new GildedRose(new Item[]{agedBrieItem});

        app.updateQuality();

        assertEquals("Aged Brie", agedBrieItem.name);
        assertEquals(-1, agedBrieItem.sellIn);
        assertEquals(50, agedBrieItem.quality);
    }

    @Test
    void givenASulfurasItem_whenCallUpdateQualityWithSellInZero_thenNothingChange() {
        Item sulfurasItem = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose app = new GildedRose(new Item[]{sulfurasItem});

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", sulfurasItem.name);
        assertEquals(0, sulfurasItem.sellIn);
        assertEquals(80, sulfurasItem.quality);
    }

    @Test
    void givenASulfurasItem_whenCallUpdateQualityWithSellMayorZero_thenNothingChange() {
        Item sulfurasItem = new Item("Sulfuras, Hand of Ragnaros", 5, 80);
        GildedRose app = new GildedRose(new Item[]{sulfurasItem});

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", sulfurasItem.name);
        assertEquals(5, sulfurasItem.sellIn);
        assertEquals(80, sulfurasItem.quality);
    }

    @Test
    void givenASulfurasItem_whenCallUpdateQualityWithSellNegative_thenNothingChange() {
        Item sulfurasItem = new Item("Sulfuras, Hand of Ragnaros", -2, 80);
        GildedRose app = new GildedRose(new Item[]{sulfurasItem});

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", sulfurasItem.name);
        assertEquals(-2, sulfurasItem.sellIn);
        assertEquals(80, sulfurasItem.quality);
    }

    @Test
    void givenABackstageItem_whenCallUpdateQualityWithSellInMayorTen_thenLessOneInNumericSellInAndOnePlusQuality() {
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 5);
        GildedRose app = new GildedRose(new Item[]{backstage});

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstage.name);
        assertEquals(14, backstage.sellIn);
        assertEquals(6, backstage.quality);
    }

    @Test
    void givenABackstageItem_whenCallUpdateQualityWithSellInMinorTen_thenLessOneInNumericSellInAndTwoPlusQuality() {
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 5);
        GildedRose app = new GildedRose(new Item[]{backstage});

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstage.name);
        assertEquals(8, backstage.sellIn);
        assertEquals(7, backstage.quality);
    }

    @Test
    void givenABackstageItem_whenCallUpdateQualityWithSellInMinorFive_thenLessOneInNumericSellInAndThreePlusQuality() {
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5);
        GildedRose app = new GildedRose(new Item[]{backstage});

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstage.name);
        assertEquals(3, backstage.sellIn);
        assertEquals(8, backstage.quality);
    }

    @Test
    void givenABackstageItem_whenCallUpdateQualityWithSellIZero_thenLessOneInNumericSellInAndQualityZero() {
        Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);
        GildedRose app = new GildedRose(new Item[]{backstage});

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstage.name);
        assertEquals(-1, backstage.sellIn);
        assertEquals(0, backstage.quality);
    }

    @Test
    void givenAConjuredItem_whenCallUpdateQualityWithSellMoreZero_thenLessOneInNumericSellInAndTwoLessQuality() {
        Item conjured = new Item("Conjured Mana Cake", 1, 6);
        GildedRose app = new GildedRose(new Item[]{conjured});

        app.updateQuality();

        assertEquals("Conjured Mana Cake", conjured.name);
        assertEquals(0, conjured.sellIn);
        assertEquals(4, conjured.quality);
    }

    @Test
    void givenAConjuredItem_whenCallUpdateQualityWithSellInZero_thenLessOneInNumericSellInAndFourLessQuality() {
        Item conjured = new Item("Conjured Mana Cake", 0, 6);
        GildedRose app = new GildedRose(new Item[]{conjured});

        app.updateQuality();

        assertEquals("Conjured Mana Cake", conjured.name);
        assertEquals(-1, conjured.sellIn);
        assertEquals(2, conjured.quality);
    }

}
