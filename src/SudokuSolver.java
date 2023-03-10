public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		Board entities obtained from www.sudokuweb.org
//		Keeping it simple with 9x9 layout size.
        int[][] board =  {
                {9, 2, 0, 8, 0, 0, 6, 5, 4},
                {7, 0, 0, 6, 1, 0, 9, 3, 2},
                {0, 0, 5, 4, 9, 2, 0, 1, 0},
                {0, 1, 7, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 9, 6, 0, 5, 0, 3},
                {5, 0, 3, 7, 0, 8, 1, 0, 0},
                {0, 0, 0, 1, 0, 7, 3, 2, 9},
                {8, 0, 0, 0, 0, 9, 4, 6, 0},
                {0, 0, 9, 0, 4, 6, 0, 8, 5}
        };
        showBoard(board);

        if(solveBoard(board)) {
            System.out.println();
            System.out.println("Solved Successfully!");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("It's an Unsolvable Board!");
            System.out.println();
        }
        showBoard(board);
    }

    private static void showBoard(int[][] board) {
        for(int row = 0; row < GRID_SIZE; row++) {
            if(row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for(int column = 0; column < GRID_SIZE; column++){
                if(column % 3 == 0 && column != 0){
                    System.out.print("|");
                }
                System.out.print(board [row][column]);
            }
            System.out.println();
        }
    }

    private static boolean CheckNumberInRow(int board[][], int number, int row) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean CheckNumberInColumn(int board[][], int number, int column) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean CheckNumberInBox(int board[][], int number, int row,int column) {
        int local_box_row = row - row % 3;
        int local_box_column = column - column % 3;

        for(int i = local_box_row; i < local_box_row + 3; i++) {
            for(int j = local_box_column; j < local_box_column + 3; j++) {
                if(board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean CheckForPlacement(int board[][], int number, int row, int column) {
        return !CheckNumberInRow(board, number, row) &&
                !CheckNumberInColumn(board, number, column)&&
                !CheckNumberInBox(board, number, row, column);
    }

    private static boolean solveBoard(int board[][]) {
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int column = 0; column < GRID_SIZE; column++) {

                if(board[row][column] == 0) {
                    for(int NumberToTry = 1; NumberToTry <= GRID_SIZE; NumberToTry++ ) {
                        if(CheckForPlacement(board, NumberToTry, row, column)) {
                            board[row][column] = NumberToTry;

                            if(solveBoard(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}

















