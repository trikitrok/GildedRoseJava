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

    private void updateQuality() {
        if (item.name.equals("Aged Brie")) {
            incrementQuality();

            if (item.sellIn < 0) {
                incrementQuality();
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality();

            if (item.sellIn < 10) {
                incrementQuality();
            }

            if (item.sellIn < 5) {
                incrementQuality();
            }

            if (item.sellIn < 0) {
                item.quality = 0;
            }
        } else {
            decrementQuality();
            if (item.sellIn < 0) {
                decrementQuality();
            }
        }
    }

    private void incrementQuality() {
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
