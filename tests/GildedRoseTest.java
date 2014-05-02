import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private GildedRose gildedRose;

    private void makeDaysPass(int numberOfDays) {
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
    public void sellInDecreasesByOneEachDay() {
        Item whatever = new Item("whatever", 2, 0);
        gildedRose = aGildedRoseWithItems(whatever);

        makeDaysPass(10);

        assertEquals(-8, whatever.sellIn);
    }

    @Test
    public void agedBrieQualityIncreasesByOneEachDayBeforeSellDate() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        makeDaysPass(2);

        assertItemsQuality(2, agedBrie);
    }

    @Test
    public void agedBrieQualityIncreasesByTwoEachDayAfterSellDate() {
        Item agedBrie = new Item("Aged Brie", 0, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        makeDaysPass(2);

        assertItemsQuality(4, agedBrie);
    }

    @Test
    public void qualityCannotBeMoreThanFifty() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        makeDaysPass(300);

        assertItemsQuality(50, agedBrie);
    }

    @Test
    public void sulfurasIsInmutable() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        gildedRose = aGildedRoseWithItems(sulfuras);

        makeDaysPass(10);

        assertItemsQuality(80, sulfuras);
    }

    @Test
    public void backstagePassesQualityIncreasesByOneEachDayBeforeTenDaysFromSellDate() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        makeDaysPass(5);

        assertItemsQuality(25, backstagePasses);
    }

    @Test
    public void backstagePassesQualityIncreasesByTwoEachDayBetweenTenAndFiveDaysBeforeSellDate() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        makeDaysPass(10);

        assertItemsQuality(35, backstagePasses);
    }

    @Test
    public void backstagePassesQualityIncreasesByThreeEachDayBetweenFiveDaysFromSellDateAndSellDate() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        makeDaysPass(15);

        assertItemsQuality(50, backstagePasses);
    }

    @Test
    public void backstagePassesQualityIsZeroAfterTheSellDate() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        makeDaysPass(16);

        assertItemsQuality(0, backstagePasses);
    }

    @Test
    public void regularItemsQualityDecreasesByOneEachDayBeforeSellDate() {
        Item regularItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(regularItem);

        makeDaysPass(10);

        assertItemsQuality(10, regularItem);
    }

    @Test
    public void perishableItemsQualityDecreasesByTwoEachDayAfterSellDate() {
        Item perishableItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(perishableItem);

        makeDaysPass(15);

        assertItemsQuality(0, perishableItem);
    }

    @Test
    public void perishableItemsQualityCannotBeLessThanZero() {
        Item perishableItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(perishableItem);

        makeDaysPass(200);

        assertItemsQuality(0, perishableItem);
    }

    @Test
    public void conjuredItemsQualityDecreasesByTwoEachDayBeforeSellDate() {
        Item conjuredItem = new Item("Conjured Mana Cake", 3, 6);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        makeDaysPass(3);

        assertItemsQuality(0, conjuredItem);
    }

    @Test
    public void conjuredItemsQualityDecreasesByFourEachDayAfterSellDate() {
        Item conjuredItem = new Item("Conjured Mana Cake", 5, 18);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        makeDaysPass(7);

        assertItemsQuality(0, conjuredItem);
    }

    @Test
    public void conjuredItemsQualityCannotBeLessThanZero() {
        Item conjuredItem = new Item("Conjured Mana Cake", 5, 18);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        makeDaysPass(200);

        assertItemsQuality(0, conjuredItem);
    }
}
