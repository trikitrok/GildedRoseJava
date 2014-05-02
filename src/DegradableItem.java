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
        item.sellIn = sellIn() - 1;
    }

    protected void updateQuality() {
        if (item.name.equals("Aged Brie")) {
            throw new RuntimeException("AgedBrie");
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            throw new RuntimeException("Backstage passes to a TAFKAL80ETC concert");
        } else {
            decrementQuality();
            if (outOfDate()) {
                decrementQuality();
            }
        }
    }

    protected void qualityVanish() {
        item.quality = 0;
    }

    protected int sellIn() {
        return item.sellIn;
    }

    protected boolean outOfDate() {
        return sellIn() < 0;
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
