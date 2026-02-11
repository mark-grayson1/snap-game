package org.example;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    private final Scanner scanner = new Scanner(System.in);
    private final String[] commands = {"Press 1 to start single player game", "Press 2 to start 2 player game",
            "Press 3 to quit"};
    private Card currentCard = null;
    private Card newCard = null;
    private boolean gameOver = false;
    int interval;
    static Timer timer = null;
    static int counter = 0;
    static boolean timerExpired = false;
    static boolean gameWon = false;

    public Snap(String name) {
        super(name);
    }

    public void playGame(){
        currentCard = null;
        shuffleDeck();
        displayMenu();
    }

    public void displayMenu(){
        boolean exiting = false;

        while (true) {
            System.out.println(""); // blank line to serparate menu display
            System.out.println("=======================================");
            System.out.println("            Main Menu");
            System.out.println("=======================================");
            printCommands(commands);
            int userSelection = readIntegerInput(commands.length);

            // if exit ...
            if( userSelection == 3) {
                return;
            }
            else if (userSelection == 2) {
                Player player1 = new Player();
                player1.setPlayerNumber(1);

                Player player2 = new Player();
                player2.setPlayerNumber(2);
                exiting = askUserToTakeTurn(player1, player2);
                if (exiting)
                    return;
            } else {
                Player player = new Player();
                player.setPlayerNumber(0);
                exiting = askUserToTakeTurn(player);
                if (exiting)
                    return;
            }
        }
    }

    protected int readIntegerInput(int limit) {
        System.out.println(String.format("Enter a number between 1 and %d:", limit));
        while( true ) {
            String line = scanner.nextLine();

            try {
                int userSelection = Integer.valueOf(line.trim());

                if( userSelection < 1 || userSelection > limit ) {
                    System.out.println("Please enter a number between 1 and " + limit);
                } else {
                    return userSelection;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and " + limit);

            }
        }
    }

    protected void printCommands(String[] commands) {
        for (int i = 0; i < commands.length; i++) {
            System.out.println((i + 1) + ": " + commands[i]);
        }
    }

    private boolean askUserToTakeTurn(Player player) {
        boolean exiting = false;

        while (true) {
            System.out.printf("Press 'enter' to take your turn or 0 to exit game.");

            String userInput = scanner.nextLine();
            String userInputClean = userInput.trim().toLowerCase();

            if (userInputClean.equals("0")) {
                exiting = true;
                return exiting;
            } else if (userInputClean.equals("")) {
                exiting = dealCardFromPack(player);
                if (exiting)
                    return exiting;
            } else {
                System.out.println("Unable to understand input, try again");
                return exiting;
            }
        }
    }

    private boolean askUserToTakeTurn(Player player1, Player player2) {
        boolean exiting = false;
        boolean firstPlayer = true;

        while (true) {
            //for single player games the player number is 0
            if (firstPlayer) {
                System.out.println("Player " + player1.playerNumber + " - press enter to take your turn or 0 to exit game.");
            } else {
                System.out.println("Player " + player2.playerNumber + " - press enter to take your turn or 0 to exit game.");
            }

            String userInput = scanner.nextLine();
            String userInputClean = userInput.trim().toLowerCase();

            if (userInputClean.equals("0")) {
                exiting = true;
                return exiting;
            } else if (userInputClean.equals("")) {
                if (firstPlayer)
                    exiting = dealCardFromPack(player1);
                else
                    exiting = dealCardFromPack(player2);
                if (exiting)
                    return exiting;
            } else {
                System.out.println("Unable to understand input, try again");
                return exiting;
            }
            firstPlayer = !firstPlayer;
        }
    }

    private boolean dealCardFromPack(Player player) {

        newCard = this.dealCard();
        System.out.println("Dealt the card - " + newCard.toString());
        System.out.println(""); // format with blank line

        // first time round set the currentCard
        if (currentCard == null) {
            currentCard = newCard;
        } else if (newCard.value == currentCard.value) {
            if (player.playerNumber > 0) {

                System.out.println("SNAP! Player " + player.playerNumber + " has an opportunity to win.");
                System.out.println("To win player " + player.playerNumber + " MUST enter snap in 2 secs otherwise you lose.");
                System.out.println("----------------------------  QUICK - ENTER snap NOW!  ----------------------------");

                //create timer task to increment counter
                TimerTask timerTask = new TimerTask() {

                    @Override
                    public void run() {
                    //     System.out.println("TimerTask executing counter is: " + counter);
                        counter++;
                    }
                };

                //create thread to print counter value
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        while (true) {
                            try {
                                if (counter == 2) {
                                    if (!gameWon)
                                        System.out.println("Too slow - count down reached 0 press 'enter' to finish");
                                    timer.cancel();//end the timer
                                    timerExpired = true;
                                    break;//end this loop
                                }
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                timer = new Timer("MyTimer");//create a new timer


                timer.scheduleAtFixedRate(timerTask, 30, 1000);//start timer in 30ms to increment  counter
                t.start();//start thread to display counter
                String userInput = scanner.nextLine();

                if (userInput != "")
                    System.out.println("You entered - " + userInput);

                if (!timerExpired && userInput.equalsIgnoreCase("snap")) {
                    gameWon = true;
                    System.out.println("CONGRATULATIONS! You won the game by snapping faster than a crocodile!!!");
                }
                else {
                    int winningPlayer = (player.playerNumber == 1) ? 2 : 1;
                    System.out.println("You were too slow or had a typo! Player " + winningPlayer + " wins!");
                }
            }
            else
                System.out.println("SNAP! Player wins, congratulations!");
            gameOver = true;
        } else {
            currentCard = newCard;
            gameOver = deckOfCards.size() == 0;
            if (gameOver)
                System.out.println("All the cards in pack have been dealt with no consecutive 2 cards the same value, computer wins - game over!");
        }

        return gameOver;
    }
}
