# Huffman Coding

## Introduction
 
The Huffman coding is a lossless compression method that uses the probabilities of symbols occurring in the data set to determine variable-length codes for each symbol. 

In this implementation, a full binary tree is recursively created by merging two symbols with the lowest value (frequency) of a heap, which are then added to a subtree and relocated to the binary tree. The process ends when all the symbols of the heap are combined. Then the binary tree is traversed and binary values of 1 or 0 are assigned to each of its edges, finally generating the codes from this path.

###### Note: This project is solely intended for educational purposes.

## Input examples
### Encoding with a dictionary
```
+-------------------------------------------+
|        H U F F M A N   C O D I N G        |
|            Created by @brensio            |
+-------------------------------------------+
To exit from the program, type 'exit' at any time.

---------------------------------------------

-----------------
|    M E N U    |
-----------------
--------------------------------------
|    1 - Encode (with dictionary)    |
--------------------------------------
-----------------------------------------
|    2 - Encode (without dictionary)    |
-----------------------------------------
--------------------
|    3 - Decode    |
--------------------
-----------------------------------------
|    Enter the number of a menu item    |
-----------------------------------------
>>> 1
-------------------------------------
|    Enter the number of symbols    |
-------------------------------------
>>> 4
-------------------------------------------------------
|    Enter both the symbol and the frequency (1/4)    |
-------------------------------------------------------
>>> a 70
-------------------------------------------------------
|    Enter both the symbol and the frequency (2/4)    |
-------------------------------------------------------
>>> b 3
-------------------------------------------------------
|    Enter both the symbol and the frequency (3/4)    |
-------------------------------------------------------
>>> c 20
-------------------------------------------------------
|    Enter both the symbol and the frequency (4/4)    |
-------------------------------------------------------
>>> d 37

---------------------------------------------

--------------------------------
|    Generated binary heap:    |
--------------------------------
Representation in layers:
                [b | 3]

            [d | 37] [c | 20] 

        [a | 70] 

List representation:
(index) [symbol | frequency]
(1) [b | 3] 
(2) [d | 37] 
(3) [c | 20] 
(4) [a | 70] 

---------------------------------------------

---------------------------------------
|    Steps of Huffman's Algorithm:    |
---------------------------------------
----------------
|    STEP 1    |
----------------
Representation in layers:
        [  | 23]

    [a | 70] [d | 37] 

List representation:
(index) [symbol | frequency]
(1) [  | 23] 
(2) [a | 70] 
(3) [d | 37] 

---------------------------------------------

----------------
|    STEP 2    |
----------------
Representation in layers:
        [  | 60]

    [a | 70] 

List representation:
(index) [symbol | frequency]
(1) [  | 60] 
(2) [a | 70] 

---------------------------------------------

----------------
|    STEP 3    |
----------------
Representation in layers:
[  | 130]



List representation:
(index) [symbol | frequency]
(1) [  | 130] 

---------------------------------------------

-------------------------------------------
|    Huffman's algorithm runtime: 13ms    |
-------------------------------------------

---------------------------------------------

----------------------------------------
|    Pre-order tree representation:    |
----------------------------------------
( 130  ( 60  ( 23  ( 3 b )( 20 c ) )( 37 d ) )( 70 a ) )

---------------------------------------------

---------------------
|    Dictionary:    |
---------------------
Symbol  |   Code
b       |   000
c       |   001
d       |   01
a       |   1

---------------------------------------------

-------------------------------------------------------------
|    Enter a text to be encoded, based on the dictionary    |
-------------------------------------------------------------
>>> aabdca

---------------------------------------------

-----------------------
|    Encoded text:    |
-----------------------

11000010011
Original size: 6 bytes
Compressed size: 2 bytes
Compression ratio: 33%
-------------------------------
|    Encoding runtime: 4ms    |
-------------------------------

---------------------------------------------

---------------------------------------------------
|    Enter 'menu' to go back or 'exit' to quit    |
---------------------------------------------------
>>> 
```

### Encoding without a dictionary

```
+-------------------------------------------+
|        H U F F M A N   C O D I N G        |
|            Created by @brensio            |
+-------------------------------------------+
To exit from the program, type 'exit' at any time.

---------------------------------------------

-----------------
|    M E N U    |
-----------------
--------------------------------------
|    1 - Encode (with dictionary)    |
--------------------------------------
-----------------------------------------
|    2 - Encode (without dictionary)    |
-----------------------------------------
--------------------
|    3 - Decode    |
--------------------
-----------------------------------------
|    Enter the number of a menu item    |
-----------------------------------------
>>> 2
------------------------------------
|    Enter a text to be encoded    |
------------------------------------
>>> avada kedavra

---------------------------------------------

--------------------------------
|    Generated binary heap:    |
--------------------------------
Representation in layers:
                        [  | 1]

                    [e | 1] [r | 1] 

                [d | 2] [a | 5] [v | 2] [k | 1] 

List representation:
(index) [symbol | frequency]
(1) [  | 1] 
(2) [e | 1] 
(3) [r | 1] 
(4) [d | 2] 
(5) [a | 5] 
(6) [v | 2] 
(7) [k | 1] 

---------------------------------------------

---------------------------------------
|    Steps of Huffman's Algorithm:    |
---------------------------------------
----------------
|    STEP 1    |
----------------
Representation in layers:
                        [e | 1]

                    [v | 2] [r | 1] 

                [d | 2] [a | 5] [  | 2] 

List representation:
(index) [symbol | frequency]
(1) [e | 1] 
(2) [v | 2] 
(3) [r | 1] 
(4) [d | 2] 
(5) [a | 5] 
(6) [  | 2] 

---------------------------------------------

----------------
|    STEP 2    |
----------------
Representation in layers:
                [v | 2]

            [d | 2] [  | 2] 

        [a | 5] [  | 2] 

List representation:
(index) [symbol | frequency]
(1) [v | 2] 
(2) [d | 2] 
(3) [  | 2] 
(4) [a | 5] 
(5) [  | 2] 

---------------------------------------------

----------------
|    STEP 3    |
----------------
Representation in layers:
                [d | 2]

            [  | 4] [  | 2] 

        [a | 5] 

List representation:
(index) [symbol | frequency]
(1) [d | 2] 
(2) [  | 4] 
(3) [  | 2] 
(4) [a | 5] 

---------------------------------------------

----------------
|    STEP 4    |
----------------
Representation in layers:
        [  | 4]

    [a | 5] [  | 4] 

List representation:
(index) [symbol | frequency]
(1) [  | 4] 
(2) [a | 5] 
(3) [  | 4] 

---------------------------------------------

----------------
|    STEP 5    |
----------------
Representation in layers:
        [a | 5]

    [  | 8] 

List representation:
(index) [symbol | frequency]
(1) [a | 5] 
(2) [  | 8] 

---------------------------------------------

----------------
|    STEP 6    |
----------------
Representation in layers:
[  | 13]



List representation:
(index) [symbol | frequency]
(1) [  | 13] 

---------------------------------------------

-------------------------------------------
|    Huffman's algorithm runtime: 13ms    |
-------------------------------------------
----------------------------------------
|    Pre-order tree representation:    |
----------------------------------------
( 13  ( 5 a )( 8  ( 4  ( 2 v )( 2  ( 1 e )( 1 r ) ) )( 4  ( 2 d )( 2  ( 1   )( 1 k ) ) ) ) )

---------------------------------------------

---------------------
|    Dictionary:    |
---------------------
Symbol  |	Code
a       |       0
v       |       100
e       |       1010
r       |       1011
d       |       110
        |       1110
k       |       1111

---------------------------------------------

-----------------------
|    Encoded text:    |
-----------------------

010001100111011111010110010010110
Original size: 13 bytes
Compressed size: 5 bytes
Compression ratio: 38%
-----------------------------
|    Total runtime: 97ms    |
-----------------------------

---------------------------------------------

---------------------------------------------------
|    Enter 'menu' to go back or 'exit' to quit    |
---------------------------------------------------

```

### Decoding

```
+-------------------------------------------+
|        H U F F M A N   C O D I N G        |
|            Created by @brensio            |
+-------------------------------------------+
To exit from the program, type 'exit' at any time.

---------------------------------------------

-----------------
|    M E N U    |
-----------------
--------------------------------------
|    1 - Encode (with dictionary)    |
--------------------------------------
-----------------------------------------
|    2 - Encode (without dictionary)    |
-----------------------------------------
--------------------
|    3 - Decode    |
--------------------
-----------------------------------------
|    Enter the number of a menu item    |
-----------------------------------------
>>> 3
-------------------------------------
|    Enter the number of symbols    |
-------------------------------------
>>> 3
-------------------------------------------------------
|    Enter both the symbol and the frequency (1/3)    |
-------------------------------------------------------
>>> a 2
-------------------------------------------------------
|    Enter both the symbol and the frequency (2/3)    |
-------------------------------------------------------
>>> b 1
-------------------------------------------------------
|    Enter both the symbol and the frequency (3/3)    |
-------------------------------------------------------
>>> r 1

---------------------------------------------

--------------------------------
|    Generated binary heap:    |
--------------------------------
Representation in layers:
        [b | 1]

    [a | 2] [r | 1] 

List representation:
(index) [symbol | frequency]
(1) [b | 1] 
(2) [a | 2] 
(3) [r | 1] 

---------------------------------------------

---------------------------------------
|    Steps of Huffman's Algorithm:    |
---------------------------------------
----------------
|    STEP 1    |
----------------
Representation in layers:
        [a | 2]

    [  | 2] 

List representation:
(index) [symbol | frequency]
(1) [a | 2] 
(2) [  | 2] 

---------------------------------------------

----------------
|    STEP 2    |
----------------
Representation in layers:
[  | 4]



List representation:
(index) [symbol | frequency]
(1) [  | 4] 

---------------------------------------------

------------------------------------------
|    Huffman's algorithm runtime: 6ms    |
------------------------------------------
-------------------------------------------------------
|    Enter an encoded text based on the dictionary    |
-------------------------------------------------------
>>> 010110
-----------------------
|    Decoded text:    |
-----------------------

abra
---------------------------------------------

---------------------------------------------------
|    Enter 'menu' to go back or 'exit' to quit    |
---------------------------------------------------

```