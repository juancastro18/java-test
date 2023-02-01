package com.gildedrose.processor.impl;

import com.gildedrose.Item;
import com.gildedrose.processor.ItemProcessor;

public final class DefaultProcessorImpl implements ItemProcessor {

    private static DefaultProcessorImpl instance;

    private DefaultProcessorImpl() {
    }

    public static synchronized ItemProcessor getInstance() {
        if (instance == null) {
            instance = new DefaultProcessorImpl();
        }
        return instance;
    }

    @Override
    public void process(Item item) {
        if (item.quality <= 0) {
            return;
        }
        if (item.sellIn > 0) {
            item.quality = item.quality - 1;
        } else {
            item.quality = item.quality - 2;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }

    }

}
