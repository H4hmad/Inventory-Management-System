# Task 1

Behavioural pattern - Options: _Strategy_ or _Observer_ pattern.
You chose: OBSERVER

## Itemise changes made (which class files were modified)

1. An interface created for observers. This interface defines a method (update) that the observer i-e the Player(s) should implement to receive changes when the storage changes (i-e item added or removed). (Observer.java)

2. The storage class will now have a list of store observers (players). This list maintains references to all registered observers. (Line 7 in Storage Class)

3. Methods to add, remove and update/notify observers are added to the storage class. Add and remove observer should be self explanatory while the notify/update method will notify the observers i-e the players of any changes made to the storage. (Lines 24, 29 and 33 till 45)

4. The observer interface is implemented in the Player class and an update method is also added into the player class which updates the store view for the Player once called. (Line 60 till 67)

5. In the App class, player will be registered as an observer of the storage(subject). (Line 15 and 19)

# Task 2

Structural pattern - _Composite_ pattern.

## Itemise changes made (which class files were modified)

1. BaseItem Class added, with all the required methods implemented.
2. Crafting and Uncrafting methods implemented in App class.
3. A list is defined to store the componenets(craftable items) and sub-componenets(base items)
   this is done to achieve the required functionality (crafting, uncrafting). (Item Class)
4. Add and Get methods added for the List defined in 3. (Item Class)
5. Getweight and Getcomposition methods modified to work for craftable items and allow for crafting/uncrafting.
6. Create method in ItemDefinition Class modified to work for craftable items as well.
7. Get method added that returns the component names that is required for Crafting.

# Task 3

## Itemised changes or new files

1.

## What was changed

1.

## Why it was changed

1.

## The benefits of the change

1.
