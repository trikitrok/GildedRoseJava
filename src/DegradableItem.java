public class DegradableItem {

    private Item item;

    public DegradableItem(Item item) {
        this.item = item;
    }

    public void degrade() {
        age();

        updateQuality();
    }

    private void age() {
        item.sellIn = item.sellIn - 1;
    }

    protected void updateQuality() {
        if (item.name.equals("Aged Brie")) {
            throw new RuntimeException("AgedBrie");
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality();

            if (item.sellIn < 10) {
                incrementQuality();
            }

            if (item.sellIn < 5) {
                incrementQuality();
            }

            if (outOfDate()) {
                item.quality = 0;
            }
        } else {
            decrementQuality();
            if (outOfDate()) {
                decrementQuality();
            }
        }
    }

    protected boolean outOfDate() {
        return item.sellIn < 0;
    }

    protected void incrementQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decrementQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
