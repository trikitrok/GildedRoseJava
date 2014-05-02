public class AgedBrie extends DegradableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        if (outOfDate()) {
            incrementQuality();
        }
    }
}
