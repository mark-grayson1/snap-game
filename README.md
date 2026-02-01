# Snap game

A card game based on the classic card game - snap. Using Java, OOP and a text based UI.


### Features

- Display of cards using Unicode representations.
- 2 player support.
- Countdown timer functionality.


### Technologies being used

- Java


### Design - basic game logic

#### 1. Create a Card class:

        1.1 Create a suite property.
        1.2 Create a symbol property.
        1.3 Create a value property.
        1.4 Create a constructor method.
        1.5 Create a toString() method.

#### 2. Create a CardGame class to hold the cards:

        2.1 Create a property - deckOfCards a collection class to contain 52 cards.
        2.2 Create a constructor for the CardGame class.
        2.3 Create a getDeck() method.

#### 3. Create methods in the CardGame class:

        3.1 Create a dealCard() method to return a card from the top of the deck.
        3.2 Create a sortDeckinNumberOrder() method to sort the deck in ascending values.
        3.3 Create a sortDeckintoSuits() method to sort the deck into ascending values grouped by card suits. 
        3.4 Create a shuffleDeck() method to shuffle the deck into a random order.

#### 4. Create a class Snap to extend the CardGame class:

        4.1 Create a playGame() method:
            4.1.1 While deck is not empty:
                4.1.1.1 call shuffleDeck() method.
                4.1.1.2 Prompt the player to press enter to take their turn.
                4.1.1.3 call the dealCard() method. 
                4.1.1.4 If snap condition reached then display a "Player won!" message and return from loop.
                Else 4.1.1.5 Check if deck empty

#### 5. Create a Player class:

        5.1 Create a property for playerName.
        5.2 Create a method displayName() to display the player name as a string.

#### 6. Update the Snap class:

        6.1 Change the while loop:
            6.1.1 Add prompt for player 2 to take their turn.
            6.1.2 Deal card for player 2.
            6.1.3 Check if either of the players has won and display which player won.
            6.1.4 If neither of the players won display a suitable message and ask if they want to play again. 

#### 7. Implement count down timer
        7.1 Update the Snap class to add a 2 second timer.
        7.2 Display a message to the player with the snap opportunity, telling them they must enter the word snap in 2 seconds or else lose the game.
        7.3 If snap entered in time congratulate the the relevant player.
        Else 7.4 Tell the other player they have won.



                    
