package com.gildedrose

import com.gildedrose.item.model.Item
import org.junit.Assert.assertEquals
import org.junit.Test

class GildedRoseTest {

    @Test
    fun updateQualityTest() {

        // instanciate one item of each type and add them to the list
        val regular = Item("+5 Dexterity Vest", 5, 10)
        val agedBrie = Item("Aged Brie", 5, 10)
        val sulfura = Item("Sulfuras, Hand of Ragnaros", 5, 80)
        val backStagePass = Item("Backstage passes to a TAFKAL80ETC concert", 15, 30)
        val conjured = Item("Conjured Mana Cake", 5, 10)

        val testItems = arrayOf(
                regular,
                agedBrie,
                sulfura,
                backStagePass,
                conjured
        )

        // init the application with the mocked list
        val app = GildedRose(testItems)

        for (i in 1..23) {

            // call update quantity once each loop
            // index i is the number of times the functin has been called
            app.updateQuality()

            when (i) {

                1 -> {
                    // updateQuality called once

                    // check that regular item quality degrades by 1
                    assertEquals(9, app.items
                            .find { item -> item.name == regular.name }?.quality)

                    // check that Aged Brie item quality increased by 1
                    assertEquals(11, app.items
                            .find { item -> item.name == agedBrie.name }?.quality)

                    // check that Conjured item quality decreased by 2
                    assertEquals(8, app.items
                            .find { item -> item.name == conjured.name }?.quality)

                    // check that backstage pass item quality increased by 1 when
                    // sellIn (15) is still > 10 - base quality is 30
                    assertEquals(31, app.items
                            .find { item -> item.name == backStagePass.name }?.quality)
                }

                6 -> {
                    // check that the regular item quality decreased by 1 for each
                    // loop (5) then by 2 once after reaching sellIn
                    // 10 - (5 * 1) - (1 * 2 ) = 3
                    assertEquals(3, app.items
                            .find { item -> item.name == regular.name }?.quality)

                    // same for Aged Brie except it must have increased by the opposite
                    // 10 + ( 5 * 1 ) + ( 1 * 2 ) = 17
                    assertEquals(17, app.items
                            .find { item -> item.name == agedBrie.name }?.quality)

                    // same for backstage pass but it is increased by 2
                    // when sellIn (base 15) is > 5 and < 10
                    // 30 + ( 5 * 1 ) + (1 * 2 ) = 37
                    assertEquals(37, app.items
                            .find { item -> item.name == backStagePass.name }?.quality)
                }


                11 -> {
                    // check that the regular item quality doesn't drop below 0
                    assertEquals(0, app.items
                            .find { item -> item.name == regular.name }?.quality)

                    // check that backstage pass quality is increased by 2
                    // when sellIn (base 15) < 15
                    // 30 + ( 5 * 1 ) + (5 * 2) + ( 1 * 3 ) = 48
                    assertEquals(48, app.items
                            .find { item -> item.name == backStagePass.name }?.quality)
                }

                16 -> {
                    // updateQuality called more than Backstage Pass sellin (15)

                    // check that the backstage pass quality has dropped to 0 after reaching sellIn
                    assertEquals(0, app.items
                            .find { item -> item.name == backStagePass.name }?.quality)
                }


                23 -> {
                    // update quality called more than enough for Aged Brie to reach
                    // its max quality (50)
                    // check that quality doesn't get higher than 50
                    assertEquals(50, app.items
                            .find { item -> item.name == agedBrie.name }?.quality)

                    // since it is the last loop, randomly check that the Sulfuras quality hasn't changed
                    assertEquals(80, app.items
                            .find { item -> item.name == sulfura.name }?.quality)
                }

            }

        }

    }


}


