public class ConcertBackstagePasses extends DegradableItem {

    public ConcertBackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        if (lessThanTenDaysToConcert()) {
            incrementQuality();
        }

        if (lessThanFiveDaysToConcert()) {
            incrementQuality();
        }

        if (outOfDate()) {
            qualityVanish();
        }
    }

    private boolean lessThanFiveDaysToConcert() {
        return sellIn() < 5;
    }

    private boolean lessThanTenDaysToConcert() {
        return sellIn() < 10;
    }
}
