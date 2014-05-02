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

            if (item.name.equals("Aged Brie")) {
                degradableItems.add(new AgedBrie(item));
            } else {
                degradableItems.add(new DegradableItem(item));
            }
        }
        return new DegradableItems(degradableItems);
    }
}