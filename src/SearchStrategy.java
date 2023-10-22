import java.util.ArrayList;
import java.util.List;

public interface SearchStrategy {
    ArrayList<ItemInterface> search(ArrayList<ItemInterface> inventory, String searchTerm);
}