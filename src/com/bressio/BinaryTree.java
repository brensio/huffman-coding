package com.bressio;

import java.util.Map;
import java.util.TreeMap;

public class BinaryTree implements Comparable<BinaryTree>{
    private char symbol;
    private int frequency;
    private BinaryTree left, right;
    private static Map<Character, String> dictionary = new TreeMap<>();

    public BinaryTree(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        left = null;
        right = null;
    }

    public BinaryTree(char symbol, int frequency, BinaryTree left, BinaryTree right) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public void show() {
        StringOut.printInline("( ");
        StringOut.printInline(String.valueOf(frequency) + " " + symbol);
        if (left != null) {
            left.show();
        }
        if (right != null) {
            right.show();
        }
        StringOut.printInline(" )");
    }

    public void showCode(String code) {
        if (symbol != '\f') {
            StringOut.printBlock(symbol + "\t\t|\t\t" + code);
            dictionary.put(symbol, code);
        } else {
            left.showCode(code + 0);
            right.showCode(code + 1);
        }
    }

    public void encode() {
        String input;
        boolean undefined;
        int size = 0;

        do {
            input = StringIn.getInstance().getInput(
                    "Enter a text to be encoded, based on the dictionary",
                    "^.+$",
                    "You have entered an invalid input"
            );

            undefined = false;

            for (char c : input.toCharArray()) {
                if (!dictionary.containsKey(c)) {
                    StringOut.printError("The text contains characters that are not in the dictionary");
                    undefined = true;
                    break;
                }
            }
        } while (undefined);

        StringOut.printNewLine();
        StringOut.printSeparator();
        StringOut.printTitleBlock("Encoded text:");
        StringOut.printNewLine();

        Stopwatch stopwatch = new Stopwatch();

        for (char c : input.toCharArray()) {
            String code = dictionary.get(c);
            StringOut.printInline(code);
            size += code.length();
        }

        StringOut.printNewLine();

        int original = (int) Math.ceil(((8.0 * input.length()) / 8.0));
        int compressed = (int) Math.ceil((size / 8.0));

        StringOut.printBlock("Original size: " + original + (original >= 2 ? " bytes" : " byte"));
        StringOut.printBlock("Compressed size: " + compressed + (compressed >= 2 ? " bytes" : " byte"));
        StringOut.printBlock("Compression ratio: " + (int) (((float) compressed / original) * 100) + "%");

        stopwatch.stop("Encoding runtime:");
    }

    public void encode(String input) {
        int size = 0;

        StringOut.printTitleBlock("Encoded text:");
        StringOut.printNewLine();

        for (char c : input.toCharArray()) {
            String code = dictionary.get(c);
            StringOut.printInline(code);
            size += code.length();
        }

        StringOut.printNewLine();

        int original = (int) Math.ceil(((8.0 * input.length()) / 8.0));
        int compressed = (int) Math.ceil((size / 8.0));

        StringOut.printBlock("Original size: " + original + (original >= 2 ? " bytes" : " byte"));
        StringOut.printBlock("Compressed size: " + compressed + (compressed >= 2 ? " bytes" : " byte"));
        StringOut.printBlock("Compression ratio: " + (int) (((float) compressed / original) * 100) + "%");
    }

    public void decode(String input) {
        BinaryTree current = this;
        StringBuilder text = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                text.append(current.symbol);
                current = this;
            }
        }
        StringOut.printTitleBlock("Decoded text:");
        StringOut.printNewLine();
        StringOut.printInline(text.toString());

    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(BinaryTree binaryTree) {
        return Integer.compare(frequency, binaryTree.frequency);
    }

    @Override
    public String toString() {
        return "[" + symbol + " | " + frequency + "]";
    }

}
