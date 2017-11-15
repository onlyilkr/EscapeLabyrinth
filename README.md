# EscapeLabyrinth

#### Internship Elimination Project

This is a game programmed with Java played on the chess board. Application was done with Breadth First Search algorithm.

### Rules

* The purpose of the game is to go from corner to corner with  white stamp on chessboard. There will be obstacles on the game board.(Black stamps)
* White stamp must be at A1
* Randomly place 3 to 9 black stamps on the game board.
* Stamps can not jump over each other
* The white stamp must meet least one black stamp while going to H8.
* White stamp can move only 1 square on each movement at the board. (Up, Down, Right, Left, Cross)
* White stamp should go the shortest way.

``` java
<-- Chessboard first situation--> B: Black stamp W: White stamp +: Path followed

  A B C D E F G H
1 W . . . . B . . 
2 . . B . . . . . 
3 . . . B . . . . 
4 . . B . . . . . 
5 . . . . . . . . 
6 . . B . . B . . 
7 . B . . . . . . 
8 . . . . . . . . 
<--Chessboard final situation -->
Path for White Stamp:
(2,2) (3,3) (4,4) (5,5) (5,6) (6,7) (7,8) (8,8) 
  A B C D E F G H
1 W . . . . B . . 
2 . + B . . . . . 
3 . . + B . . . . 
4 . . B + . . . . 
5 . . . . + + . . 
6 . . B . . B + . 
7 . B . . . . . + 
8 . . . . . . . + 

```
