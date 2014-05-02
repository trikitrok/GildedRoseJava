public abstract class DegradableItem {

    private Item item;

    public DegradableItem(Item item) {
        this.item = item;
    }

    public DegradableItem(DegradableItem degradableItem) {
        this.item = degradableItem.item;
    }

    public void degrade() {
        age();

        updateQuality();
    }

    private void age() {
        item.sellIn = sellIn() - 1;
    }

    abstract protected void updateQuality();

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
