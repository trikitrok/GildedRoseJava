import java.util.ArrayList;
import java.util.List;

public class DegradableItems {

    List<DegradableItem> degradableItems;

    public DegradableItems(List<DegradableItem> degradableItems) {
        this.degradableItems = degradableItems;
    }

    public void degrade() {
        for (DegradableItem item : degradableItems) {
            item.degrade();
        }
    }

    public static DegradableItems createFrom(Item[] items) {
        List<DegradableItem> degradableItems = new ArrayList<DegradableItem>();
        for (Item item : items) {
            if (item.name.contains("Sulfuras, Hand of Ragnaros"))
                continue;
            degradableItems.add(DegradableItem.createFrom(item));
        }
        return new DegradableItems(degradableItems);
    }
}
