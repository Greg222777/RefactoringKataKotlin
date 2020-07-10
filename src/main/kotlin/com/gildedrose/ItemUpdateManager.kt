package com.gildedrose

/**
 * This class is handling Item Updaters
 */
class ItemUpdateManager {

    /**
     * Instantiates an ItemAdapter according the the item name
     * calls pre-sellIn updates, sellIn update then post-sellIn update on the ItemUpdater
     * @param item : the item to update
     */
    fun updateItem(item: Item) {
        when (item.name) {
            ItemType.AGED_BRIE.key -> AgedBrieItemUpdater(item)
            ItemType.BACKSTAGE_PASS.key -> BackstagePassItemUpdater(item)
            ItemType.SULFURAS.key -> SulfurasItemUpdater(item)
            ItemType.CONJURED.key -> ConjuredItemUpdater(item)
            else -> BaseItemUpdater(item)
        }
                .doPreSellInUpdateOperations()
                .updateSellIn()
                .doPostSellInUpdateOperations()
    }
}

/**
 * Item types, key is the name which must be checked for
 */
enum class ItemType(val key: String?) {
    REGULAR(null),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured");
}
