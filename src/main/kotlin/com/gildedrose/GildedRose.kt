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

            when (item.name) {

                AGED_BRIE_NAME -> {
                    // increment quality, cannot be higher than 50
                    if (item.quality < 50) {
                        item.quality++
                    }
                    //decrement sellIn
                    item.sellIn--

                    // if sellIn is nagative and item quality lower than 50, increment quality
                    if (item.sellIn < 0 && item.quality < 50) {
                        item.quality++
                    }
                }

                BACKSTAGE_PASS_NAME -> {
                    // increment quality, cannot be higher than 50
                    if (item.quality < 50) {
                        item.quality++
                    }

                    // twice if sellIn <11
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality++
                        }
                    }

                    // three times is sellin <6
                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality++
                        }
                    }

                    //decrement sellIn
                    item.sellIn--

                    // quality drops to 0 if sellIn is negative
                    if (item.sellIn < 0) {
                        item.quality = 0
                    }


                }

                SULFURAS_NAME -> {

                }

                //REGULAR
                else -> {
                    // if quality is positive, decrement
                    if (item.quality > 0) {
                        item.quality--
                    }
                    //decrement sellIn
                    item.sellIn--

                    // if sellIn is negative and item quality is greater than 0, decrement quality
                    if (item.sellIn < 0 && item.quality > 0) {
                        item.quality--
                    }
                }
            }
        }
    }

}

