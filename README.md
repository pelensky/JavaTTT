[![Build Status](https://travis-ci.org/pelensky/JavaTTT.svg?branch=master)](https://travis-ci.org/pelensky/JavaTTT)
[![Coverage Status](https://coveralls.input/repos/github/pelensky/JavaTTT/badge.svg?branch=master)](https://coveralls.input/github/pelensky/JavaTTT?branch=master)

## Java Tic Tac Toe 

This is a Tic Tac Toe game built in Java, with three game types:

1. Human VS Human
2. Human VS Computer
3. Computer VS Computer

At this stage, the computer player selects a random available space, it does not implement the Minimax algorithm.

#### Prerequisites 
1. Install [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

#### Running instructions
1. Clone the repository by clicking on the green "Clone or Download" button
2. Select Download Zip
3. Double click the zip file to unzip it
4. In terminal, CD into the repository
5. Build the app by running `$ ./gradlew build`
6. Run the tests by running `$ ./gradlew cleanTest test`
7. Play the game by running `$ ./gradlew --console plain run`

#### The Rules

The rules of tic-tac-toe are as follows:

* There are two players in the game (X and O)
* Players take turns until the game is over
* A player can claim a field if it is not already taken
* A turn ends when a player claims a field
* A player wins if they claim all the fields in a row, column or diagonal
* A game is over if a player wins
* A game is over when all fields are taken

#### Note
* This was designed for future extendability in mind
    * The board class was built to be initialized with number of rows (currently the app only supports a 3x3 board)
    * The player class was built for markers to be any string (the app currently supports X and O)   
* While the application does not currently support bigger game or use different markers, this would be an easy change later if required