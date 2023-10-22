# Task 1

Behavioural pattern - Options: _Strategy_ or _Observer_ pattern.
You chose: OBSERVER

## Itemise changes made (which class files were modified)

1. An interface created for observers. This interface defines a method (update) that the observer i-e the Player(s) should implement to receive changes when the storage changes (i-e item added or removed). (Observer.java)

2. The storage class will now have a list of store observers (players). This list maintains references to all registered observers. (Storage Class)

3. Methods to add, remove and update/notify observers are added to the storage class. Add and remove observer should be self explanatory while the notify/update method will notify the observers i-e the players of any changes made to the storage. (Storage Class)

4. The observer interface is implemented in the Player class and an update method is also added into the player class which updates the store view for the Player once called. (Player Class)

5. In the App class, player will be registered as an observer of the storage(subject). (App Class)

Further Details:

- When items are stored or retrieved in the Storage class, it calls the notifyObservers method.
- The notifyObservers method iterates through the list of registered observers (in this case, Player objects) and calls
  their update method.
- In the Player class, the update method updates the storageView based on the current state of the storage, effectively
  synchronizing the player's view with the storage changes.

This pattern helps in decoupling the subject (storage) and its observers (players). It allows multiple players to observe the same storage object, and any changes to the storage are automatically reflected in all observing players' views

# Task 2

Structural pattern - _Composite_ pattern.

## Itemise changes made (which class files were modified)

(Componenets can be craftable items or baseitems and if craftable items, it can be made up of sub-componenets which can be craftable items or base items as so on)

1. Crafting and Uncrafting methods implemented in App class.

2. A list is defined to store the componenets this is done to achieve the required functionality (crafting, uncrafting). (Item Class)

3. Add and Get methods added for the List defined in 3. (Item Class)

4. Getweight and Getcomposition methods modified to work for craftable items and allow for crafting/uncrafting. (Item Class)

5. Create method in ItemDefinition Class modified to work for craftable items as well. (ItemDefinition Class)

6. Get method added that returns the component names that is required for Crafting. (ItemDefinition Class)

Further Details:

ItemInterface is the interface that defines the common operations for both leaf and composite objects. These
methods allow one to access and manipulate the properties and structure of items.

The Item class implements the ItemInterface. It represents a leaf object in the composite structure. It has a definition, which contains information about the item, and a list of components, which can be other items. In this implementation, Item can act as both a single item (leaf) or a container for a group of items namely a Craftable Item (composite).

Key Elements:

The key elements of the Composite Design Pattern in my modified code:

Common Interface: The ItemInterface defines a common interface for both leaf and composite objects. All the methods in the interface are used to access or manipulate the properties of items, and they are implemented in the Item class.

Leaf and Composite Classes: The Item class represents both the leaf and composite objects. It can have a List of components, which allows it to act as a composite (container) for other items. The addComponent method is used to add components to a composite item.

Composition: The getWeight method in the Item class demonstrates how the composite structure is traversed to calculate the total weight. It combines the weight of the current item with the weights of its components, making it suitable for composite items that consist of other items.

Component Access: The getComponents method in the Item class allows access to the components of a composite item. This is useful when inspecting or manipulating the sub-items of a composite item.

Composite Description: The getCompositionDescription method generates a description that lists the components of a composite item. It demonstrates how information about the structure of a composite item can be accessed or displayed.

//Equality and Matching: The equals and isOf methods are used for comparison and matching based on the item's definition. This is a common practice in composite structures where you want to check if two items have the same definition.// (removed in Task 3 as they're unused).

# Task 3

## Itemised changes or new files

No.1 Strategy Pattern implemented for Item Searching

1. SearchStrategy.java Added

2. AllSearchStrategy.java Added

3. NameSearchStrategy.java Added

4. DescriptionSearchStrategy.java Added

5. Modifications made in App.java and Inventory.java

No.2 Use of Generics for Items

1. Inventory Class

2. SearchStrategy Interface

3. AllSearchStrategy Class

4. NameSearchStrategy Class

5. NameSearchStrategy Class

6. Storage Class

## What was changed

No.1

1. In App class, the setupSearching method has been modified to facilitate for the SearchStrategy implemented.

2. In Inventory class, a SearchStrtagy object is defined that will keep track of the strategy i-e any of the three

3. SearchItems method is modified to work with searching implementation. (Inventory CLass)

No.2

1. Inventory class is now a generic class that takes a type parameter T which extends ItemInterface. This means that the stock
   attribute and the searchStrategy attribute are now of type ArrayList<T> and SearchStrategy<T> respectively.

2. The SearchStrategy interface is also made generic by introducing the type parameter T. This allows different
   implementations of SearchStrategy to work with any class that implements ItemInterface.

To sum it up, all references to ItemInterface within the Inventory, Storage and Player classes are replaced with the type parameter T.

## Why it was changed

No.1

1. The change was made to introduce a more maintainable and flexible way to handle item searching in the code.
   the original code used a hard coded approach which made the code less extensible and harder to maintain.

2. By introducing the Strategy Pattern, my code separates the search strategies from the Inventory class,
   making it easier to add new search strategies and change the behavior of searching without directly modifying
   the Inventory class.

No2.

Type Flexibility: The introduction of generics allows the Inventory class to work with various types that implement the ItemInterface. This change makes the code more versatile and adaptable, enabling it to handle different types of items without modifying the class.

Type Safety: Generics provide type safety by catching type-related errors at compile time. This ensures that operations performed on items are type-correct, reducing the likelihood of runtime exceptions caused by type mismatches.

Code Reusability: By using generics, the Inventory class can be employed with different item types, reducing the need to create separate inventory classes for each type. This enhances code reusability and eliminates redundancy.

Modularity: The use of generics in the SearchStrategy interface ensures that various search strategies can work with any type that implements the ItemInterface. This promotes code modularity and allows for easy extension of search strategies without altering existing code.

## The benefits of the change

No.1

1. This makes it easy to add new strategies or modify existing ones without affecting other parts of the code.

2. The Strategy Pattern allows for the easy addition of new search strategies. You can create new strategy
   classes without modifying the existing code, making the system more extensible.

3. Other benefits can inlcude improved readability, reducing the use of conditional complexity
   (as in the original SearchItems there were multiple conditional statements utiltized), and better maintainability.

No.2

1. Compatibility: The code becomes more versatile, as it can be applied to a wider range of item types. This promotes flexibility and reduces the need for redundant code for different item types.

Type Safety: Compile-time checks ensure that type-related errors are identified early in the development process, enhancing code reliability and reducing the likelihood of runtime errors.

Reduced Casting: Generics eliminate the need for casting objects, leading to cleaner and more readable code. This change simplifies item addition, removal, and searching within the inventory.

Improved Documentation: The use of generics enhances code documentation by clearly specifying the expected type (e.g., T in the Inventory class). This makes it easier for other developers to understand and use the code correctly.

///

Minor Changes:

- Removed unused methods from Inventory, Item and ItemInterface classes.
- Modified the Reader class slightly, DuplicateItemName and getItemDef now use Java Lambdas and Streams, which
  makes the two methods more concise and easier to read and reduces duplication.
