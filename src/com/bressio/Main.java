package com.bressio;

public class Main {

    private static String input;

    public static void main(String args[]) {
        StringOut.printNewLine();
        StringOut.printInline("+-------------------------------------------+");
        StringOut.printNewLine();
        StringOut.printBlock("|        H U F F M A N   C O D I N G        |");
        StringOut.printBlock("|            Created by @brensio            |");
        StringOut.printInline("+-------------------------------------------+");
        StringOut.printNewLine();
        StringOut.printBlock("To exit from the program, type 'exit' at any time.");
        StringOut.printNewLine();
        StringOut.printSeparator();

        showMenu();
    }

    public static void showMenu() {

        StringOut.printTitleBlock("M E N U");
        StringOut.printTitleBlock("1 - Encode (with dictionary)");
        StringOut.printTitleBlock("2 - Encode (without dictionary)");
        StringOut.printTitleBlock("3 - Decode");

        input = StringIn.getInstance().getInput(
                "Enter the number of a menu item",
                "^[1-3]$",
                "You have entered an invalid option"
        );

        switch (input) {
            case "1" : manualEncoding();
                break;
            case "2" : autoEncoding();
                break;
            case "3" : manualDecoding();
                break;
        }
    }

    private static void manualEncoding() {

        input = StringIn.getInstance().getInput(
                "Enter the number of symbols",
                "^\\d+$",
                "You have entered an invalid input"
        );

        BinaryMinHeap heap = new BinaryMinHeap(Integer.parseInt(input));
        heap.loadData();
        StringOut.printTitleBlock("Generated binary heap:");
        heap.print();

        Stopwatch stopwatch = new Stopwatch();
        heap.applyHuffmans();
        stopwatch.stop("Huffman's algorithm runtime:");

        StringOut.printNewLine();
        StringOut.printSeparator();
        heap.showEncoding();

        returnToMenu();
    }

    private static void autoEncoding() {

        input = StringIn.getInstance().getInput(
                "Enter a text to be encoded",
                "^.+$",
                "You have entered an invalid input"
        );

        Stopwatch stopwatchA = new Stopwatch();

        BinaryMinHeap heap = new BinaryMinHeap(StringFormat.countUniqueCharacters(input), input);
        heap.loadData(input);
        StringOut.printTitleBlock("Generated binary heap:");
        heap.print();

        Stopwatch stopwatchB = new Stopwatch();
        heap.applyHuffmans();
        stopwatchB.stop("Huffman's algorithm runtime:");

        heap.showEncoding();

        stopwatchA.stop("Total runtime:");

        returnToMenu();
    }

    private static void manualDecoding() {

        input = StringIn.getInstance().getInput(
                "Enter the number of symbols",
                "^\\d+$",
                "You have entered an invalid input"
        );

        BinaryMinHeap heap = new BinaryMinHeap(Integer.parseInt(input));
        heap.loadData();
        StringOut.printTitleBlock("Generated binary heap:");
        heap.print();
        Stopwatch stopwatchB = new Stopwatch();
        heap.applyHuffmans();
        stopwatchB.stop("Huffman's algorithm runtime:");

        input = StringIn.getInstance().getInput(
                "Enter an encoded text based on the dictionary",
                "^.+$",
                "You have entered an invalid input"
        );

        heap.decode(input);

        returnToMenu();
    }

    private static void returnToMenu() {
        StringOut.printNewLine();
        StringOut.printSeparator();
        input = StringIn.getInstance().getInput(
                "Enter 'menu' to go back or 'exit' to quit",
                "^.+$",
                "You have entered an invalid input"
        );
        showMenu();
    }
}
