package com.gildedrose

import com.gildedrose.item.logic.ItemUpdateManager
import com.gildedrose.item.model.Item

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        val itemUpdateManager = ItemUpdateManager()
        items.map { item -> itemUpdateManager.updateItem(item) }
    }

}