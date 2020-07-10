package com.gildedrose.item.logic

import com.gildedrose.item.model.Item

class ConjuredItemUpdater(item: Item) : BaseItemUpdater(item) {
    override fun doPreSellInUpdateOperations(): BaseItemUpdater {

            item.quality = item.quality -2

        // post-check that quality doesn't drop below 0
        if (item.quality < DEFAULT_MIN_ITEM_QUALITY){
            item.quality = 0
        }
        return this
    }

    override fun doPostSellInUpdateOperations() {
        // if sellIn is negative, decrement quality
        if (item.sellIn < 0) {
            item.quality = item.quality -2
        }

        // post-check that quality doesn't drop below 0
        if (item.quality < DEFAULT_MIN_ITEM_QUALITY){
            item.quality = 0
        }

    }
}