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
}
