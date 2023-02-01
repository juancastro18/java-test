package com.gildedrose.processor.impl;

import com.gildedrose.Item;
import com.gildedrose.processor.ItemProcessor;

public final class AgedBrieProcessorImpl implements ItemProcessor {

    private static AgedBrieProcessorImpl instance;

    private AgedBrieProcessorImpl() {
    }

    public static synchronized AgedBrieProcessorImpl getInstance() {
        if (instance == null) {
            instance = new AgedBrieProcessorImpl();
        }
        return instance;
    }

    @Override
    public void process(Item item) {
        if (item.quality >= 50) {
            return;
        }
        if (item.sellIn > 0) {
            item.quality = item.quality + 1;
        } else {
            item.quality = item.quality + 2;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
