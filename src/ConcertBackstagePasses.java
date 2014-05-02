public class ConcertBackstagePasses extends DegradableItem {

    public ConcertBackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        if (sellIn() < 10) {
            incrementQuality();
        }

        if (sellIn() < 5) {
            incrementQuality();
        }

        if (outOfDate()) {
            qualityVanish();
        }
    }
}
