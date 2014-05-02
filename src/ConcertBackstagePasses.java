public class ConcertBackstagePasses extends DegradableItem {

    public ConcertBackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        if (concertDayIsClose()) {
            incrementQuality();
        }

        if (concertDayIsEvenCloser()) {
            incrementQuality();
        }

        if (outOfDate()) {
            qualityVanish();
        }
    }

    private boolean concertDayIsEvenCloser() {
        return sellIn() < 5;
    }

    private boolean concertDayIsClose() {
        return sellIn() < 10;
    }
}
