package com.gildedrose.processor.impl;

import com.gildedrose.Item;
import com.gildedrose.processor.ItemProcessor;

public final class SulfurasProcessorImpl implements ItemProcessor {

    private static SulfurasProcessorImpl instance;

    private SulfurasProcessorImpl() {
    }

    public static synchronized SulfurasProcessorImpl getInstance() {
        if (instance == null) {
            instance = new SulfurasProcessorImpl();
        }
        return instance;
    }

    @Override
    public void process(Item item) {
        //Sulfuros object doesn't process
    }

    @Override
    public void lessSellIn(Item item) {
        //Sulfuros object doesn't less the SellIn value
    }

}
