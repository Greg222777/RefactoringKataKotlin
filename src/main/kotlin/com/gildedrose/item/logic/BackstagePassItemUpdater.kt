package com.gildedrose.item.logic

import com.gildedrose.item.model.Item

/**
 * Child class of BaseItemUpdater, functions which have a different behaviour from REGULAR item
 * are overridden here
 */
class BackstagePassItemUpdater(item: Item) : BaseItemUpdater(item) {

    override fun doPreSellInUpdateOperations(): BaseItemUpdater {

        // increment quality, cannot be higher than max quality
        if (item.quality < DEFAULT_MAX_ITEM_QUALITY) {
            item.quality++
        }

        // twice if sellIn <11
        if (item.sellIn < 11) {
            if (item.quality < DEFAULT_MAX_ITEM_QUALITY) {
                item.quality++
            }
        }

        // three times is sellin <6
        if (item.sellIn < 6) {
            if (item.quality < DEFAULT_MAX_ITEM_QUALITY) {
                item.quality++
            }
        }

        return this
    }

    override fun doPostSellInUpdateOperations() {
        // quality drops to 0 if sellIn is negative
        if (item.sellIn < 0) {
            item.quality = 0
        }
    }
}