import java.util.ArrayList;
import java.util.List;

public interface SearchStrategy<T extends ItemInterface> {
    
    ArrayList<T> search(ArrayList<T> inventory, String searchTerm);
}