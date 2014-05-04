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
        return new DegradableItems(selectDegradable(items));
    }

    private static List<DegradableItem> selectDegradable(Item[] items) {
        List<DegradableItem> degradableItems = new ArrayList<DegradableItem>();
        for (Item item : items) {
            if (!isImmutable(item))
                degradableItems.add(DegradableItem.createFrom(item));
        }
        return degradableItems;
    }

    private static boolean isImmutable(Item item) {
        return item.name.contains("Sulfuras, Hand of Ragnaros");
    }
}
