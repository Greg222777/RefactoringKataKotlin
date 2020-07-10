package com.gildedrose.item.logic

import com.gildedrose.item.model.Item

/**
 * This is the base item updater for REGULAR items
 * All other item updaters are children of this class
 * Child classes override its functions if the behaviour must be different
 */
open class BaseItemUpdater(val item: Item) {

    companion object {
        const val DEFAULT_MAX_ITEM_QUALITY = 50
        const val DEFAULT_MIN_ITEM_QUALITY = 0
    }

    /**
     * quality operations done BEFORE sellIn is updated
     * @return ItemUpdater  to be able to call updateSellIn()
    when it is instantiated without having to assign the object
     */
    open fun doPreSellInUpdateOperations(): BaseItemUpdater {
        // if quality is greater than min quality, decrement
        if (item.quality > DEFAULT_MIN_ITEM_QUALITY) {
            item.quality--
        }
        return this
    }

    /**
     * @return ItemUpdater  to be able to call doPostSellInUpdateOperations()
    when it is instantiated without having to assign the object
     */
    open fun updateSellIn(): BaseItemUpdater {

        //decrement sellIn
        item.sellIn--

        return this
    }

    /**
     * quality operations done AFTER sellIn is updated
     */
    open fun doPostSellInUpdateOperations() {
        // if sellIn is negative and item quality is greater than min quality, decrement quality
        if (item.sellIn < 0 && item.quality > DEFAULT_MIN_ITEM_QUALITY) {
            item.quality--
        }
    }
}