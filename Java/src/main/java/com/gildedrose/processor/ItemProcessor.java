package com.gildedrose.processor;

import com.gildedrose.Item;

public interface ItemProcessor {
     void process(Item item);

     default void lessSellIn(Item item){
         item.sellIn = item.sellIn - 1;
     }
}
