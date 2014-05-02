public abstract class DegradableItem {

    static public DegradableItem createFrom(Item item) {
        if (item.name.contains("Conjured")) {
            return new ConjuredItem(createRegular(item));
        }
        return createRegular(item);
    }

    public void degrade() {
        age();
        updateQuality();
    }

    private void age() {
        item.sellIn = sellIn() - 1;
    }

    abstract protected void updateQuality();

    private Item item;

    protected DegradableItem(Item item) {
        this.item = item;
    }

    protected DegradableItem(DegradableItem degradableItem) {
        this.item = degradableItem.item;
    }

    static private DegradableItem createRegular(Item item) {
        if (item.name.contains("Aged Brie")) {
            return new AgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new ConcertBackstagePasses(item);
        } else {
            return new PerishableItem(item);
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

    protected void decrementQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
