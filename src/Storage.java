import java.util.ArrayList;
import java.util.List;

public class Storage<T extends ItemInterface> {
    private String storageName;
    private Inventory<T> items;
    private List<Observer> observers = new ArrayList<>();

    public Storage(String name, Inventory<T> startingInventory) {
        storageName = name;
        items = startingInventory;
    }

    public Inventory<T> getInventory() {
        return items;
    }

    public String getName() {
        return storageName;
    }
    
    public void store(T item) {
        items.addOne(item);
        notifyObservers();
    }

    public T retrieve(T item) throws ItemNotAvailableException {
        T removed = items.remove(item);
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
