public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            degrade(item);
        }
    }

    private void degrade(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return;

        new DegradableItem(item).degrade();
    }
}