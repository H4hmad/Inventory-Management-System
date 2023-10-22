# Task 1

Behavioural pattern - Options: _Strategy_ or _Observer_ pattern.
You chose: OBSERVER

## Itemise changes made (which class files were modified)

1. An interface created for observers. This interface defines a method (update) that the observer i-e the Player(s) should implement to receive changes when the storage changes (i-e item added or removed). (Observer.java)

2. The storage class will now have a list of store observers (players). This list maintains references to all registered observers. (Storage Class)

3. Methods to add, remove and update/notify observers are added to the storage class. Add and remove observer should be self explanatory while the notify/update method will notify the observers i-e the players of any changes made to the storage. (Storage Class)

4. The observer interface is implemented in the Player class and an update method is also added into the player class which updates the store view for the Player once called. (Player Class)

5. In the App class, player will be registered as an observer of the storage(subject). (App Class)

# Task 2

Structural pattern - _Composite_ pattern.

## Itemise changes made (which class files were modified)

1. Crafting and Uncrafting methods implemented in App class.

2. A list is defined to store the componenets and sub-componenets
   this is done to achieve the required functionality (crafting, uncrafting). (Item Class)

3. Add and Get methods added for the List defined in 3. (Item Class)

4. Getweight and Getcomposition methods modified to work for craftable items and allow for crafting/uncrafting. (Item Class)

5. Create method in ItemDefinition Class modified to work for craftable items as well. (ItemDefinition Class)

6. Get method added that returns the component names that is required for Crafting. (ItemDefinition Class)

Additional Details:
ItemInterface is the interface that defines the common operations for both leaf and composite objects. These
methods allow one to access and manipulate the properties and structure of items.

The Item class implements the ItemInterface. It represents a leaf object in the composite structure. It has a definition, which contains information about the item, and a list of components, which can be other items. In this implementation, Item can act as both a single item (leaf) or a container for a group of items namely a Craftable Item (composite).

# Task 3

## Itemised changes or new files

No.1 Strategy Pattern implemented for Item Searching

1. SearchStrategy.java Added

2. AllSearchStrategy.java Added

3. NameSearchStrategy.java Added

4. DescriptionSearchStrategy.java Added

5. Modifications made in App.java and Inventory.java

No.2

## What was changed

No.1

1. In App class, the setupSearching method has been modified to facilitate for the SearchStrategy implemented.

2. In Inventory class, a SearchStrtagy object is defined that will keep track of the strategy i-e any of the three

3. SearchItems method is modified to work with searching implementation. (Inventory CLass)

## Why it was changed

No.1

1. The change was made to introduce a more maintainable and flexible way to handle item searching in the code.
   the original code used a hard coded approach which made the code less extensible and harder to maintain.

2. By introducing the Strategy Pattern, the code separates the search strategies from the Inventory class,
   making it easier to add new search strategies and change the behavior of searching without directly modifying
   the Inventory class.

## The benefits of the change

No.1

1. This makes it easy to add new strategies or modify existing ones without affecting other parts of the code.

2. The Strategy Pattern allows for the easy addition of new search strategies. You can create new strategy
   classes without modifying the existing code, making the system more extensible.

3. Other benefits can inlcude improved readability, reducing the use of conditional complexity
   (as in the original SearchItems there were multiple conditional statements utiltized), and better maintainability.

No.2
