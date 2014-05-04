public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        degradableItems().degrade();
    }

    private DegradableItems degradableItems() {
        return DegradableItems.createFrom(items);
    }
}