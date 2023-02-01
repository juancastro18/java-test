package com.gildedrose.processor;

import com.gildedrose.processor.impl.*;

public class ProcessorFactory {

    private ProcessorFactory() {
    }

    public static ItemProcessor getItemProcessor(String itemName) {

        ItemProcessor itemProcessor;
        if (itemName.contains("Aged Brie")) {
            itemProcessor = AgedBrieProcessorImpl.getInstance();
        } else if (itemName.contains("Backstage passes")) {
            itemProcessor = BackstagePassesProcessorImpl.getInstance();
        } else if (itemName.contains("Sulfuras")) {
            itemProcessor = SulfurasProcessorImpl.getInstance();
        } else if (itemName.contains("Conjure")) {
            itemProcessor = ConjureProcessorImpl.getInstance();
        } else {
            itemProcessor = DefaultProcessorImpl.getInstance();
        }

        return itemProcessor;
    }

}
