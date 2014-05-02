public class PerishableItem extends DegradableItem {

    public PerishableItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decrementQuality();

        if (outOfDate()) {
            decrementQuality();
        }
    }
}
