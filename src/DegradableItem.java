public abstract class DegradableItem {

    static public DegradableItem createFrom(Item item) {
        if (aConjured(item)) {
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
        if (anAgedBrie(item)) {
            return new AgedBrie(item);
        } else if (aConcertBackstagePasses(item)) {
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
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    protected void decrementQuality() {
        if (item.quality > MINIMUM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    private static boolean aConjured(Item item) {
        return item.name.contains("Conjured");
    }

    private static boolean aConcertBackstagePasses(Item item) {
        return item.name.contains("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean anAgedBrie(Item item) {
        return item.name.contains("Aged Brie");
    }

    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;
}
