public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            degrade(items[i]);
        }
    }

    private void degrade(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return;

        age(item);

        updateQuality(item);
    }

    private void age(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            incrementQuality(item);

            if (item.sellIn < 0) {
                incrementQuality(item);
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality(item);

            if (item.sellIn < 10) {
                incrementQuality(item);
            }

            if (item.sellIn < 5) {
                incrementQuality(item);
            }

            if (item.sellIn < 0) {
                item.quality = 0;
            }
        } else {
            decrementQuality(item);
            if (item.sellIn < 0) {
                decrementQuality(item);
            }
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}