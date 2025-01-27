package org.example;

import java.util.Scanner;

public class App {
    public static int getInput(int lowerBound, int upperBound, String prompt, String errorMessage, int defaultValue) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(prompt + " Enter 'default' to use the default value (" + defaultValue + ") or 'exit' to quit.");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("default")) {
                    userInput = defaultValue;
                    validInput = true;
                } else if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting input prompt...");
                    return Integer.MIN_VALUE; 
                } else {
                    userInput = Integer.parseInt(input);
                    if (userInput >= lowerBound && userInput <= upperBound) {
                        validInput = true; 
                    } else {
                        System.out.println(errorMessage);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage); 
            } catch (java.util.NoSuchElementException e) {
                System.out.println("No input detected. Exiting...");
                return Integer.MIN_VALUE; 
            }
        }
        return userInput;
    }

    public static void main(String[] args) {
        int lowerBound = 0;
        int upperBound = 100;
        String prompt = "Please enter a value between " + lowerBound + " and " + upperBound + ":";
        String errorMessage = "Your value is invalid. Please try again.";
        int defaultValue = 50;

        int result = getInput(lowerBound, upperBound, prompt, errorMessage, defaultValue);

        if (result != Integer.MIN_VALUE) {
            System.out.println("The value chosen by the user is " + result);
        } else {
            System.out.println("The user exited without providing input.");
        }
    }
}
