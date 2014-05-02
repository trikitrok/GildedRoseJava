import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        degradableItems().degrade();
    }

    private DegradableItems degradableItems() {
        List<DegradableItem> degradableItems = new ArrayList<DegradableItem>();
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros"))
                continue;
            degradableItems.add(createDegradable(item));
        }
        return new DegradableItems(degradableItems);
    }

    private DegradableItem createDegradable(Item item) {

        if (item.name.contains("Conjured")) {
            return new ConjuredItem(createRegular(item));
        }

        return createRegular(item);
    }

    private DegradableItem createRegular(Item item) {
        if (item.name.equals("Aged Brie")) {
            return new AgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new ConcertBackstagePasses(item);
        } else {
            return new PerishableItem(item);
        }
    }
}