import java.util.ArrayList;
import java.util.List;

public class NameSearchStrategy implements SearchStrategy {
    @Override
    public ArrayList<ItemInterface> search(ArrayList<ItemInterface> inventory, String searchTerm) {
        ArrayList<ItemInterface> result = new ArrayList<>();
        for (ItemInterface item : inventory) {
            if (item.getName().toLowerCase().contains(searchTerm)) {
                result.add(item);
            }
        }
        return result;
    }
}