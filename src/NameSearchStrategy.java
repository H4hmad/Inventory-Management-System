import java.util.ArrayList;

public class NameSearchStrategy<T extends ItemInterface> implements SearchStrategy<T> {
    @Override
    public ArrayList<T> search(ArrayList<T> inventory, String searchTerm) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : inventory) {
            if (item.getName().toLowerCase().contains(searchTerm)) {
                result.add(item);
            }
        }
        return result;
    }
}