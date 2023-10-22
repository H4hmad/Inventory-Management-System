import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

public class App {
    private Player player;
    private Storage storage;
    private JFrame frame;
    private PageManager manager;

    public App(Player p, Storage s) {

        player = p;
        storage = s;

        player.setStorageView(storage.getInventory());

        storage.addObserver(player);
        manager = new PageManager(player, storage);

        // Setup of sorting
        setupSearching((InventoryPage) manager.findPage("Player Inventory"));
        setupSearching((InventoryPage) manager.findPage("Storage"));

        // Setup of craftng
        setupCrafting((ItemCraftPage) manager.findPage("Item Crafting"), player);
        setupUncrafting((ProductPage) manager.findPage("Product Page"), player);

        // Window creation
        manager.refresh();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(manager.getJPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void setupSearching(InventoryPage page) {
        page.addSearchByButton(new SearchByButton("All", () -> {
            player.getInventory().setSearchStrategy(new AllSearchStrategy());
        }));
    
        page.addSearchByButton(new SearchByButton("Name", () -> {
            player.getInventory().setSearchStrategy(new NameSearchStrategy());
        }));
    
        page.addSearchByButton(new SearchByButton("Description", () -> {
            player.getInventory().setSearchStrategy(new DescriptionSearchStrategy());
        }));
    }

    void setupCrafting(ItemCraftPage page, Player player) {
        page.setCraftAction((def) -> {
            boolean canCraft = true;
            List<Item> components = new ArrayList<>();

        for (String componentName : def.getComponentNames()) {
            Optional<ItemDefinition> componentDef = ItemDictionary.get().defByName(componentName);
            if (componentDef.isPresent()) {
                ItemDefinition componentItemDef = componentDef.get();
                int qtyInInventory = player.getInventory().qtyOf(componentItemDef);
                if (qtyInInventory <= 0) {
                    canCraft = false;
                    break;
                }
                components.add(componentItemDef.create());
            }
        }

        if (canCraft) {
            Item craftedItem = def.create();

            for (Item component : components) {
                    player.getInventory().removeOne(component.getDefinition());
            }
            player.getInventory().addOne(craftedItem);
        } else {
            System.out.println("Cannot craft. Missing Crafting Materials.");
        }
    });
    }

    void setupUncrafting(ProductPage page, Player player) {
        page.setUncraftAction(item -> {
            List<ItemInterface> components = item.getComponents();
            for (ItemInterface component : components) {
                    player.getInventory().addOne(component);
            }
            player.getInventory().removeOne(item.getDefinition());
        });
    }
}
