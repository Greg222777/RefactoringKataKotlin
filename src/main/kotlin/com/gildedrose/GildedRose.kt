package com.gildedrose

class GildedRose(var items: Array<Item>) {

    companion object {
        const val AGED_BRIE_NAME = "Aged Brie"
        const val BACKSTAGE_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS_NAME = "Sulfuras, Hand of Ragnaros"
    }

    fun updateQuality() {
        for (item in items) {

            // considering items are
            // AGED_BRIE
            // BACKSTAGE_PASS
            // REGULAR
            // SULFURAS


            /*
            if item is not AGED BRIE, BACKSTAGE PASS or SULFURAS (simplified : is REGULAR)
            and quality > 0
            decrement quality by 1
             */
            if (isRegularItem(item)) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            }

            /*
            if item is AGED_BRIE or BACKSTAGE_PASS
            and quality is lower than 50
            increment quality by 1
             */
            if (item.name == AGED_BRIE_NAME
                    || item.name == BACKSTAGE_PASS_NAME) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }

            /*
            if item is BACKSTAGE_PASS
            and quality is lower than 50
            increment quality by 1
            a second time if sellin < 10
            and a third time if sellin is lower than 5
             */

            if (item.name == BACKSTAGE_PASS_NAME) {

                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            }

            /*
             for all items except SULFURAS
             decrement sellIn
          */
            if (item.name != SULFURAS_NAME) {
                item.sellIn = item.sellIn - 1
            }

            /*
            if item is AGED_BRIE
            if sellIn is nagative
            and item quality lower than 50
            increment quality
             */
            if (item.name == AGED_BRIE_NAME) {
                if (item.sellIn < 0 && item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }

            /*
            if item is not AGED_BRIE, BACKSTAGE_PASS or SUFURAS (simplified : is REGULAR)
            if quality is negative and sellIn is positive
            decrement quality
             */
            if (isRegularItem(item)) {
                if (item.sellIn < 0 && item.quality > 0) {
                    item.quality = item.quality - 1
                }
            }

            /*
            for BACKSTAGE_PASS
            if sellIn is negative, item quality = 0
             */
            if (item.name == BACKSTAGE_PASS_NAME) {
                if (item.sellIn < 0) {
                    item.quality = 0
                }
            }
        }
    }

    private fun isRegularItem(item: Item): Boolean {
        return item.name != SULFURAS_NAME
                && item.name != AGED_BRIE_NAME
                && item.name != BACKSTAGE_PASS_NAME
    }

}

