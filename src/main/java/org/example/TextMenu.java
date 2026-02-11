package org.example;

import java.util.Scanner;

public class TextMenu {
    final private Scanner scanner = new Scanner(System.in);
    private final String[] commands = {"Press 1 to start single player game", "Press 2 to start 2 player game",
            "Press 3 to quit"};

    public int GetUserSelection(){

        while (true) {
            System.out.println(""); // blank line to separate menu display
            System.out.println("=======================================");
            System.out.println("            Main Menu");
            System.out.println("=======================================");
            printCommands(commands);
            int userSelection = readIntegerInput(commands.length);

            // if exit ...
            if( userSelection == 3) {
                return 3;
            }
            else if (userSelection == 2) {
                return 2;
            } else {
                return 1;
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
}
