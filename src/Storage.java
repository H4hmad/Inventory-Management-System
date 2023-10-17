import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String storageName;
    private Inventory items;
    private List<Observer> observers = new ArrayList<>();

    public Storage(String name, Inventory startingInventory) {
        storageName = name;
        items = startingInventory;
    }

    public Inventory getInventory() {
        return items;
    }

    public String getName() {
        return storageName;
    }
    
    public void store(ItemInterface item) {
        items.addOne(item);
        notifyObservers();
    }

    public ItemInterface retrieve(ItemInterface item) throws ItemNotAvailableException {
        ItemInterface removed = items.remove(item);
        notifyObservers();
        return removed;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
}
