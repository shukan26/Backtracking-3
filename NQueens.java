
//Time Complexity : O (n!) 
//Space complexity : O (n^2) 

/**
 * Solves the N-Queens problem and returns all valid board configurations.
 * Uses backtracking to place queens row by row and validate positions.
 * Returns a list of string lists representing each solution board.
 */

import java.util.*;


public class NQueens {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<List<String>>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);
        return result;
    }

    public void helper(boolean[][] board, int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(board, row, j, n)) {
                //action
                board[row][j] = true;

                //recurse to next row
                helper(board, row + 1, n);

                //backtrack placement
                board[row][j] = false;
            }
        }
    }

    public boolean isValid(boolean[][] board, int row, int col, int n) {
        int tempRow = row;
        int tempCol = col;

        //check up
        while (tempRow >= 0) {
            if (board[tempRow][tempCol])
                return false;
            tempRow--;
        }

        //check diagonal left
        tempRow = row;
        while (tempRow >= 0 && tempCol >= 0) {
            if (board[tempRow][tempCol])
                return false;
            tempRow--;
            tempCol--;
        }

        //check diagonal right
        tempRow = row;
        tempCol = col;
        while (tempRow >= 0 && tempCol < n) {
            if (board[tempRow][tempCol])
                return false;
            tempRow--;
            tempCol++;
        }

        return true;
    }
}
