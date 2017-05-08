[![Build Status](https://travis-ci.org/pelensky/JavaTTT.svg?branch=master)](https://travis-ci.org/pelensky/JavaTTT)
[![Coverage Status](https://coveralls.io/repos/github/pelensky/JavaTTT/badge.svg?branch=master)](https://coveralls.io/github/pelensky/JavaTTT?branch=master)

## Java Tic Tac Toe 

This is a Tic Tac Toe game built in Java, with three game types:

1. Human VS Human
2. Human VS Computer
3. Computer VS Computer

At this stage, the computer player selects a random available space, it does not implement the Minimax algorithm.

#### Running instructions
1. Clone the repository by clicking on the green "Clone or Download" button
2. Select Download Zip
3. Double click the zip file to unzip it
4. In terminal, CD into the repository
5. Build the app by running `$ gradle build`
6. Run the tests by running `$ gradle cleanTest test`
7. Play the game by running `$ gradle --console plain run`

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
* This was built for later extendability in mind
    * The board can be initialized with number of rows (3 is passed in as an argument when the game is created)
    * Players markers can be any string (X and O are assigned when an instance of the game is created)   
* While the application does not currently support bigger game or use different markers, this would be an easy change later if required