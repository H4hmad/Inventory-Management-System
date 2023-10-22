public class Player<T extends ItemInterface> implements Observer {
    private String name;
    private Inventory<T> inventory;
    private double carryWeightCapacity;
    private Inventory<T> storageView;

    public Player(String playerName, double carryCapacity, Inventory<T> sInventory) {
        name = playerName;
        carryWeightCapacity = carryCapacity;
        inventory = sInventory;
    }

    public void setStorageView(Inventory<T> storageInventory) {
        storageView = storageInventory;
    }

    public Inventory<T> getStorageView() {
        return storageView;
    }

    public String getName() {
        return name;
    }

    public Inventory<T> getInventory() {
        return inventory;
    }

    public double getCarryCapacity() {
        return carryWeightCapacity;
    }

    public double getCurrentWeight() {
        double carrying = 0;
        for (T item : getInventory().searchItems("")) {
            carrying += item.getWeight();
        }
        return carrying;
    }

    public void store(T item, Storage storage) throws ItemNotAvailableException {
        // Do we have the item we are trying to store
        if (!inventory.searchItems("").contains(item)) {
            throw new ItemNotAvailableException(item.getDefinition());
        }
        storage.store(inventory.remove(item));
    }

    public void retrieve(T item, Storage<T> storage) throws ItemNotAvailableException, ExceedWeightCapacity {
        // Does the Storage have the item we are trying to retrieve
        if (!storageView.searchItems("").contains(item)) {
            throw new ItemNotAvailableException(item.getDefinition());
        }
        if (getCurrentWeight() + item.getWeight() > getCarryCapacity()) {
            throw new ExceedWeightCapacity(this, item);
        }
        inventory.addOne(storage.retrieve(item));
    }

     @Override
    public void update() {
        setStorageView(storageView);
    }
}
