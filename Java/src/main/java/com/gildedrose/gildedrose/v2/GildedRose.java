package com.gildedrose.gildedrose.v2;

import com.gildedrose.Item;
import com.gildedrose.processor.ItemProcessor;
import com.gildedrose.processor.ProcessorFactory;

public class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemProcessor itemProcessor = ProcessorFactory.getItemProcessor(item.name);
            itemProcessor.process(item);
            itemProcessor.lessSellIn(item);
        }
    }
}
