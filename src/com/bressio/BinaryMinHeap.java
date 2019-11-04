package com.bressio;

import java.util.HashMap;
import java.util.Map;

public class BinaryMinHeap {
    private int n;
    private int size;
    private	BinaryTree[] vector;
    private String input;

    public BinaryMinHeap(int size) {
        n = size;
        this.size = size;
        vector = new BinaryTree[size+1];
        input = null;
    }

    public BinaryMinHeap(int size, String input) {
        n = size;
        this.size = size;
        vector = new BinaryTree[size+1];
        this.input = input;
    }

    public boolean empty() {
        return n == 0;
    }

    public void adjust(int i) {
        BinaryTree x = vector[i];

        while (2 * i <= n) {
            int leftChild = 2 * i;
            int rightChild = (2 * i) + 1;
            int smallestChild = leftChild;

            if ((leftChild != n) && (vector[rightChild].compareTo(vector[leftChild]) < 0)) {
                smallestChild = rightChild;
            }
            
            if (vector[smallestChild].compareTo(x) < 0) {
                vector[i] = vector[smallestChild];
            } else {
                break;
            }

            i = smallestChild;
        }

        vector[i] = x;
    }

    public void makeHeap() {
        for(int i = n / 2; i > 0; i--)
            adjust(i);
    }

    public void loadData() {
        int errors = 0;
        StringBuilder symbols = new StringBuilder();

        for (int i = 0; i < size + errors; i++) {
            StringOut.printInputDialog(
                    "Enter both the symbol and the frequency" +
                            " (" + (i + 1 - errors) + "/" + size + ")");
            String input = StringIn.getInstance().textInput();

            if (StringFormat.isValid(input, "^. \\d+$")) {
                if (!symbols.toString().contains(String.valueOf(StringFormat.getChar(input)))) {
                    symbols.append(String.valueOf(StringFormat.getChar(input)));
                    vector[i + 1 - errors] = new BinaryTree(StringFormat.getChar(input), StringFormat.getInt(input));
                } else {
                    StringOut.printError("You have entered a duplicate symbol");
                    errors++;
                }
            } else {
                StringOut.printError("You have entered an invalid input");
                errors++;
            }
        }
        makeHeap();

        StringOut.printNewLine();
        StringOut.printSeparator();
    }

    public void loadData(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (!frequencyMap.containsKey(c)) {
                frequencyMap.put(c, 1);
            } else {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            }
        }

        char[] symbols = new char[size];
        int[] frequencies = new int[size];

        int count = 0;

        for (char s : frequencyMap.keySet()){
            symbols[count] = s;
            frequencies[count] = frequencyMap.get(s);
            count++;
        }

        for (int i = 0; i < size; i++) {
            vector[i + 1] = new BinaryTree(symbols[i], frequencies[i]);
        }

        makeHeap();

        StringOut.printNewLine();
        StringOut.printSeparator();
    }

    public void applyHuffmans() {
        int count = 1;

        StringOut.printSeparator();
        StringOut.printTitleBlock("Steps of Huffman's Algorithm:");

        while (n > 1) {
            BinaryTree t1 = removeMin();
            BinaryTree t2 = removeMin();

            BinaryTree parent = new BinaryTree('\f', t1.getFrequency() + t2.getFrequency(), t1, t2);

            insert(parent);

            StringOut.printTitleBlock("STEP " + count);
            print();
            StringOut.printSeparator();
            count++;
        }
    }

    public void showEncoding() {
        StringOut.printTitleBlock("Pre-order tree representation:");
        vector[1].show();

        StringOut.printNewLine(2);
        StringOut.printSeparator();
        StringOut.printTitleBlock("Dictionary:");
        StringOut.printBlock("Symbol\t|\tCode");
        vector[1].showCode("");
        StringOut.printNewLine();
        StringOut.printSeparator();
        if (input != null) {
            vector[1].encode(input);
        } else {
            vector[1].encode();
        }
    }

    public void decode(String input) {
        vector[1].decode(input);
    }

    public void insert(BinaryTree x) {
        if (size == n) {
            StringOut.printError("The list is full");
            return;
        }

        n++;
        int pos = n;

        vector[0] = x;

        while(x.compareTo(vector[pos/2]) < 0) {
            vector[pos] = vector[ pos/2 ];
            pos /= 2;
        }

        vector[pos] = x;
    }

    public BinaryTree removeMin() {
        BinaryTree smallestElement;

        if(this.empty()) {
            StringOut.printError("The list is empty");
            return null;
        }

        smallestElement = vector[1];
        vector[1] = vector[n];
        n--;
        adjust(1);

        return smallestElement;
    }

    public void print() {

        StringOut.printBlock("Representation in layers:");

        int s = (n / 2) * 8;
        String offset = StringFormat.repeat(" ", s);
        int count = 0;

        while (count <= Math.sqrt(n)) {
            StringOut.printInline(offset);
            if (count == 0) {
                StringOut.printInline(vector[1].toString());
            } else {
                for (int i = (int) Math.pow(2, count); i <= Math.pow(2, count + 1) - 1; i++) {
                    if (i <= n) {
                        StringOut.printInline(vector[i].toString() + " ");
                    }
                }
            }
            s = s - 4 >= 0 ? s - 4 : 0;
            offset = StringFormat.repeat(" ", s);
            count++;
            StringOut.printNewLine(2);
        }

        StringOut.printBlock("List representation:");
        StringOut.printBlock("(index) [symbol | frequency]");

        for(int i = 1; i <= n; i++) {
            StringOut.printBlock("(" + i + ") " + vector[i].toString() + " ");
        }

        StringOut.printNewLine();
    }
}
