package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        val itemUpdateManager = ItemUpdateManager()
        items.map { item ->  itemUpdateManager.updateItem(item)}
    }

}