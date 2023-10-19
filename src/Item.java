import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Item implements ItemInterface {
    private ItemDefinition definition;
    private List<Item> components;

    /**
     * Creates an Item instance with a set definition.
     * The composition list is (created but) left empty. For composite items, the sub-components
     * should be retrieved/removed from some item source, and added with Item::Add(ItemInterface).
     * @param def
     */
    public Item(ItemDefinition def) {
        definition = def;
        components = new ArrayList<>();
    }

    public void addComponent(Item component) {
        components.add(component);
    }

    public List<Item> getComponents(){
        return components;
    }

    @Override
    public double getWeight() {
        double weight = definition.getWeight().orElse(0.0);
        if (!components.isEmpty()) {
            weight += components.stream().mapToDouble(ItemInterface::getWeight).sum();
        }
        return weight;
    }

    @Override
    public String getName() {
        return definition.getName();
    }

    @Override
    public String getDescription() {
        return definition.getDescription();
    }

    @Override
    public ItemDefinition getDefinition() {
        return definition;
    }

    @Override
    public String getCompositionDescription() {
         if (!components.isEmpty()) {
            return "Crafted from: " + components.stream()
                .map(Item::getName)
                .collect(Collectors.joining(", "));
        }
        return "";
        }

    @Override
    public boolean equals(ItemInterface other) {
        return isOf(other.getDefinition());
    }

    @Override
    public boolean isOf(ItemDefinition def) {
        return getName().equals(def.getName());
    }

    @Override
    public String toString() {
        String output = String.format("Item: %s\nDescription: %s\nWeight: %.2f",
            getName(), getDescription(), getWeight());
        output += "\nHashCode: " + Integer.toHexString(this.hashCode());
        return output;
    }

}