import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private GildedRose gildedRose;

    private void afterDays(int numberOfDays) {
        for (int i = 0; i < numberOfDays; ++i) {
            gildedRose.updateQuality();
        }
    }

    private void assertItemsQuality(int quality, Item item) {
        assertEquals(quality, item.quality);
    }

    private GildedRose aGildedRoseWithItems(Item... items) {
        return new GildedRose(items);
    }

    @Test
    public void sulfurasIsInmutable() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        gildedRose = aGildedRoseWithItems(sulfuras);

        afterDays(10);

        assertItemsQuality(80, sulfuras);
        assertEquals(0, sulfuras.sellIn);
    }

    @Test
    public void sellInDecreasesByOneEachDay() {
        Item notSulfuras = new Item("notSulfuras", 2, 0);
        gildedRose = aGildedRoseWithItems(notSulfuras);

        afterDays(10);

        assertEquals(-8, notSulfuras.sellIn);
    }

    @Test
    public void agedBrieQualityIncreasesByOneEachDayBeforeSellDate() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        afterDays(2);

        assertItemsQuality(2, agedBrie);
    }

    @Test
    public void agedBrieQualityIncreasesByTwoEachDayAfterSellDate() {
        Item agedBrie = new Item("Aged Brie", 0, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        afterDays(2);

        assertItemsQuality(4, agedBrie);
    }

    @Test
    public void qualityCannotBeMoreThanFifty() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        afterDays(300);

        assertItemsQuality(50, agedBrie);
    }

    @Test
    public void backstagePassesQualityIncreasesByOneEachDayBeforeTenDaysFromSellDate() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(5);

        assertItemsQuality(5, backstagePasses);
    }

    @Test
    public void backstagePassesQualityIncreasesByTwoEachDayBetweenTenAndFiveDaysBeforeSellDate() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(7);

        assertItemsQuality(9, backstagePasses);
    }

    @Test
    public void backstagePassesQualityIncreasesByThreeEachDayBetweenFiveDaysFromSellDateAndSellDate() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(15);

        assertItemsQuality(30, backstagePasses);
    }

    @Test
    public void backstagePassesQualityIsZeroAfterTheSellDate() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(16);

        assertItemsQuality(0, backstagePasses);
    }

    @Test
    public void perishableItemsQualityDecreasesByOneEachDayBeforeSellDate() {
        Item regularItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(regularItem);

        afterDays(10);

        assertItemsQuality(10, regularItem);
    }

    @Test
    public void perishableItemsQualityDecreasesByTwoEachDayAfterSellDate() {
        Item perishableItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(perishableItem);

        afterDays(15);

        assertItemsQuality(0, perishableItem);
    }

    @Test
    public void perishableItemsQualityCannotBeLessThanZero() {
        Item perishableItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(perishableItem);

        afterDays(200);

        assertItemsQuality(0, perishableItem);
    }

    @Test
    public void conjuredItemsQualityDecreasesByTwoEachDayBeforeSellDate() {
        Item conjuredItem = new Item("Conjured Mana Cake", 3, 6);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        afterDays(3);

        assertItemsQuality(0, conjuredItem);
    }

    @Test
    public void conjuredItemsQualityDecreasesByFourEachDayAfterSellDate() {
        Item conjuredItem = new Item("Conjured Mana Cake", 5, 18);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        afterDays(7);

        assertItemsQuality(0, conjuredItem);
    }

    @Test
    public void conjuredItemsQualityCannotBeLessThanZero() {
        Item conjuredItem = new Item("Conjured Mana Cake", 5, 18);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        afterDays(200);

        assertItemsQuality(0, conjuredItem);
    }

    @Test
    public void conjuredSulfurasIsInmutable() {
        Item conjuredSulfuras = new Item("Conjured Sulfuras, Hand of Ragnaros", 5, 18);
        gildedRose = aGildedRoseWithItems(conjuredSulfuras);

        afterDays(200);

        assertItemsQuality(18, conjuredSulfuras);
        assertEquals(5, conjuredSulfuras.sellIn);
    }

    @Test
    public void conjuredAgedBrieQualityIncreasesByTwoEachDayBeforeSellDate() {
        Item agedBrie = new Item("Conjured Aged Brie", 2, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        afterDays(2);

        assertItemsQuality(4, agedBrie);
    }

    @Test
    public void conjuredBackstagePassesQualityIncreasesTwiceFaster() {
        Item backstagePasses = new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 15, 0);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(15);

        assertItemsQuality(50, backstagePasses);
    }

    @Test
    public void conjuredBackstagePassesQualityIsZeroAfterTheSellDate() {
        Item backstagePasses = new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 15,
                20);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(16);

        assertItemsQuality(0, backstagePasses);
    }

}
