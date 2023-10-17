# Task 1

Behavioural pattern - Options: _Strategy_ or _Observer_ pattern.
You chose: OBSERVER

## Itemise changes made (which class files were modified)

1. An interface created for observers. This interface defines a method (update) that the observer i-e the Player(s) should implement to receive changes when the storage changes (i-e item added or removed). (Observer.java)

2. The storage class will now have a list of store observers (players). This list maintains references to all registered observers. (Line 7 in Storage Class)

3. Methods to add, remove and update/notify observers are added to the storage class. Add and remove observer should be self explanatory while the notify/update method will notify the observers i-e the players of any changes made to the storage. (Lines 24, 29 and 33 till 45)

4. The observer interface is implemented in the Player class and an update method is also added into the player class which updates the store view for the Player once called. (Line 60 till 67)

5. In the App class, player will be registered as an observer of the storage(subject). (Line 15)

# Task 2

Structural pattern - _Composite_ pattern.

## Itemise changes made (which class files were modified)

1.

# Task 3

## Itemised changes or new files

1.

## What was changed

1.

## Why it was changed

1.

## The benefits of the change

1.
