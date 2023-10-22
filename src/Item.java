import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Item implements ItemInterface {
    private ItemDefinition definition;
    private List<ItemInterface> components;

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

    public List<ItemInterface> getComponents(){
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
                .map(ItemInterface::getName)
                .collect(Collectors.joining(", "));
        }
        return "";
        }
}