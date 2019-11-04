package com.bressio;

import static com.bressio.StringFormat.repeat;

public final class StringOut {

    private enum Color {
        RESET("\u001B[0m"), GREEN("\u001B[32m"), RED("\u001B[31m"), BLUE("\u001B[34m"), PURPLE("\u001B[35m");

        Color(String color) {
            this.color = color;
        }
        private String color;

        public String getColor() {
            return color;
        }
    }

    private StringOut() {}

    public static void printInputDialog(String str) {
        System.out.print(Color.GREEN.getColor() +
                repeat("-", str.length() + 10) + '\n' +
                "| " + repeat(" ", 3) + str + repeat(" ", 3) + " |" + '\n' +
                repeat("-", str.length() + 10) +
                '\n' + ">>> ");
        resetColor();
    }

    public static void printError(String str) {
        System.out.println(Color.RED.getColor() +
                repeat("-", str.length() + 16) + '\n' +
                "| " + "[!]=[ " + str + " ]=[!]" + " |" + '\n' +
                repeat("-", str.length() + 16));
        resetColor();
    }

    public static void printBlock(String str) {
        System.out.println(Color.BLUE.getColor() + str.replaceAll("\\f", " "));
        resetColor();
    }

    public static void printTitleBlock(String str) {
        System.out.println(Color.BLUE.getColor() +
                repeat("-", str.length() + 10) + '\n' +
                "| " + repeat(" ", 3) + str + repeat(" ", 3) + " |" + '\n' +
                repeat("-", str.length() + 10));
        resetColor();
    }

    public static void printFootnote(String str) {
        System.out.println(Color.PURPLE.getColor() +
                repeat("-", str.length() + 10) + '\n' +
                "| " + repeat(" ", 3) + str + repeat(" ", 3) + " |" + '\n' +
                repeat("-", str.length() + 10));
        resetColor();
    }

    public static void printInline(String str) {
        System.out.print(Color.BLUE.getColor() + str.replaceAll("\\f", " "));
        resetColor();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printNewLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

    public static void printSeparator() {
        System.out.println(repeat("-", 45) + '\n');
    }

    private static void resetColor() {
        System.out.print(Color.RESET.getColor());
    }
}
