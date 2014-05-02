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
            degradableItems.add(DegradableItem.createFrom(item));
        }
        return new DegradableItems(degradableItems);
    }
}