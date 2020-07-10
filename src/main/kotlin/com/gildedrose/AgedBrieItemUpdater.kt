package com.gildedrose

/**
 * Child class of BaseItemAdapter, functions which have a different behaviour from REGULAR item
 * are overridden here
 */
class AgedBrieItemUpdater(item: Item) : BaseItemUpdater(item) {

    override fun doPreSellInUpdateOperations(): BaseItemUpdater {
        // increment quality, cannot be higher than max quality
        if (item.quality < DEFAULT_MAX_ITEM_QUALITY) {
            item.quality++
        }

        return this
    }

    override fun doPostSellInUpdateOperations() {
        // if sellIn is negative and item quality lower than max quality, increment quality
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++
        }
    }
}