package org.example;


import java.util.Scanner;

public class Snap extends CardGame {

    private Scanner scanner = new Scanner(System.in);
    private String commands[] = {"Press 1 to start the game", "Press 2 to quit"};

    public Snap(String name) {
        super(name);
    }

    public void playGame(){
        boolean exiting = false;

        while (true) {
            printCommands(commands);
            int userSelection = readIntegerInput(commands.length);

            // if exit ...
            if( userSelection == 2) {
                return;
            }
            else {
                exiting = askUserToTakeTurn();
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

    protected String readStringInput(String message) {
        System.out.println(message);

        while (true) {
            String userInput = scanner.nextLine();

            String userInputClean = userInput.trim().toLowerCase();

            if (!userInputClean.equals("")) {
                return userInputClean;
            } else {
                System.out.println("Unable to understand input, try again");
            }
        }
    }

    protected void printCommands(String[] commands) {
        for (int i = 0; i < commands.length; i++) {
            System.out.println((i + 1) + ": " + commands[i]);
        }
    }

    private boolean askUserToTakeTurn() {
        boolean exiting = false;

        while (true) {
            System.out.println("Press enter to take your turn or 0 to exit game.");
            String userInput = scanner.nextLine();

            String userInputClean = userInput.trim().toLowerCase();

            if (userInputClean.equals("0")) {
                exiting = true;
                return exiting;
            } else if (userInputClean.equals("")) {
                System.out.println("Card dealt from the pack");
            } else {
                System.out.println("Unable to understand input, try again");
            }
        }
    }
}
