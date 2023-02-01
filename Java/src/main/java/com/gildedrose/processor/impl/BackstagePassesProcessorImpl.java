package com.gildedrose.processor.impl;

import com.gildedrose.Item;
import com.gildedrose.processor.ItemProcessor;

public final class BackstagePassesProcessorImpl implements ItemProcessor {

    private static BackstagePassesProcessorImpl instance;

    private BackstagePassesProcessorImpl() {
    }

    public static synchronized BackstagePassesProcessorImpl getInstance() {
        if (instance == null) {
            instance = new BackstagePassesProcessorImpl();
        }
        return instance;
    }

    @Override
    public void process(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality = item.quality + 3;
        } else if (item.sellIn <= 10) {
            item.quality = item.quality + 2;
        } else {
            item.quality = item.quality + 1;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
