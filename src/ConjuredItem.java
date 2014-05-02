public class ConjuredItem extends DegradableItem {

    private DegradableItem degradableItem;

    public ConjuredItem(DegradableItem degradableItem) {
        super(degradableItem);
        this.degradableItem = degradableItem;
    }

    @Override
    protected void updateQuality() {
        degradableItem.updateQuality();
        degradableItem.updateQuality();
    }
}
