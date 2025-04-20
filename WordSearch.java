/**Time complexity 	O(m × n × 4^L)
    1.	The outer double loop (exist) runs once for every cell in the board → O(m × n)
	2.	For each starting cell that matches word.charAt(0), you may perform a DFS.
	3.	In the worst case, each DFS explores in 4 directions for L letters → O(4^L) recursive calls.

Even though the cell is marked as visited, the theoretical branching factor per cell is 4 (up, down, left, right), hence 4^L.
**/

// Space complexity: O(L) for the recursion stack, where L is the length of the word.

/**
 * Determines if a given word exists in a 2D board by searching adjacent cells.
 * Uses DFS with backtracking to explore all possible paths starting from each cell.
 * Returns true if the word can be constructed from adjacent letters in the board.
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length
                || word.charAt(index) != board[row][col]) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row, col + 1, index + 1) ||
                dfs(board, word, row, col - 1, index + 1);

        board[row][col] = temp;
        return found;
    }
}