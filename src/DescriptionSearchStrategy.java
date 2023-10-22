import java.util.ArrayList;
import java.util.List;

public class DescriptionSearchStrategy implements SearchStrategy {
    @Override
    public ArrayList<ItemInterface> search(ArrayList<ItemInterface> inventory, String searchTerm) {
        ArrayList<ItemInterface> result = new ArrayList<>();
        for (ItemInterface item : inventory) {
            if (item.getDescription().toLowerCase().contains(searchTerm)) {
                result.add(item);
            }
        }
        return result;
    }
}