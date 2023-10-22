import java.util.ArrayList;

public class AllSearchStrategy<T extends ItemInterface> implements SearchStrategy<T> {
    @Override
    public ArrayList<T> search(ArrayList<T> inventory, String searchTerm) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : inventory) {
            if (item.getName().toLowerCase().contains(searchTerm) || item.getDescription().toLowerCase().contains(searchTerm)) {
                result.add(item);
            }
        }
        return result;
    }
}