# Sudoku Solver
## Introduction

This is a Java program that solves Sudoku puzzles. A Sudoku puzzle is a 9x9 grid, divided into nine 3x3 sub-grids, where each row, column, and sub-grid must contain the numbers 1 through 9 without repetition. The input to the program is a partially filled Sudoku grid, where 0s represent empty cells, and the output is the completed puzzle.

The program uses a recursive backtracking algorithm to solve the puzzle. It starts by iterating through each cell of the grid and checking if it is empty. If a cell is empty, it attempts to place each number from 1 to 9 in that cell and recursively solves the puzzle with the new number in place. If a placement is not possible for any number, it backtracks to the previous cell and tries a different number. If all numbers fail, it backtracks further until it finds a valid placement for the current cell or determines that the puzzle is unsolvable.
Code Structure

The program consists of a single class named SudokuSolver. The main method initializes a partially filled Sudoku board, prints the initial state of the board, and then calls the solveBoard method to solve the puzzle. If a solution is found, it prints the solved board, and if the puzzle is unsolvable, it prints an error message.

The solveBoard method takes a partially filled Sudoku board as input and returns true if the puzzle is solvable and false if it is unsolvable. It uses a nested loop to iterate through each cell of the board and recursively solve the puzzle using the CheckForPlacement method to check if a number can be placed in a given cell. If a placement is possible, the method sets the cell to the new number and recursively calls itself to solve the next cell. If the next cell cannot be solved with any of the remaining numbers, the method backtracks and tries a different number for the current cell. If all numbers fail, it backtracks further until it finds a valid placement or determines that the puzzle is unsolvable.

The CheckNumberInRow, CheckNumberInColumn, and CheckNumberInBox methods are helper methods that check if a number already exists in a given row, column, or sub-grid. The showBoard method is a helper method that prints the Sudoku board to the console in a human-readable format.

![alt text](![alt text](http://url/to/img.png))
