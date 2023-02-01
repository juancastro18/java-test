package com.gildedrose.processor.impl;

import com.gildedrose.Item;
import com.gildedrose.processor.ItemProcessor;

public final class ConjureProcessorImpl implements ItemProcessor {

    private static ConjureProcessorImpl instance;

    private ConjureProcessorImpl() {
    }

    public static synchronized ItemProcessor getInstance() {
        if (instance == null) {
            instance = new ConjureProcessorImpl();
        }
        return instance;
    }

    @Override
    public void process(Item item) {
        if (item.quality <= 0) {
            return;
        }
        if (item.sellIn > 0) {
            item.quality = item.quality - 2;
        } else {
            item.quality = item.quality - 4;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }

    }

}
