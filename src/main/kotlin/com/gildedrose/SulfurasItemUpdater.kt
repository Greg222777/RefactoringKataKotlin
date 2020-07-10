package com.gildedrose

/**
 * Child class of BaseItemAdapter, functions which have a different behaviour from REGULAR item
 * are overridden here
 * SULFURAS being immutable, the functions must be overridden and empty
 */
class SulfurasItemUpdater(item: Item) : BaseItemUpdater(item) {
    override fun doPreSellInUpdateOperations(): BaseItemUpdater {
        // do nothing
        return this
    }

    override fun updateSellIn(): BaseItemUpdater {
        // do nothing
        return this
    }

    override fun doPostSellInUpdateOperations() {
        // do nothing
    }
}