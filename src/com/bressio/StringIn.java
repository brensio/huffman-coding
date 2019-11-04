package com.bressio;

import java.util.Scanner;

public class StringIn {

    private static final StringIn singleton = new StringIn();
    private Scanner scanner;

    private StringIn() {
        scanner = new Scanner(System.in);
    }

    public String textInput() {
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            System.exit(0);
        }
        return input;
    }

    public String getInput(String request, String pattern, String invalidInputError) {
        String input;
        boolean valid = false;

        do {
            StringOut.printInputDialog(request);

            input = textInput();

            if (!StringFormat.isValid(input, pattern)) {
                StringOut.printError(invalidInputError);
            } else {
                valid = true;
            }
        } while (!valid);

        return input;
    }

    public static StringIn getInstance(){
        return singleton;
    }
}
