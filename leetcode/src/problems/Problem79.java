package problems;

/*

79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 */

public class Problem79 {

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public boolean exist(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) return false;

        visited[i][j] = true;

        boolean found = exist(board, word, i + 1, j, index + 1, visited);
        if (!found) {
            found = exist(board, word, i, j + 1, index + 1, visited);
        }
        if (!found) {
            found = exist(board, word, i - 1, j, index + 1, visited);
        }
        if (!found) {
            found = exist(board, word, i, j - 1, index + 1, visited);
        }

        visited[i][j] = false;

        return found;
    }

    public static void main(String[] args) {
        Problem79 problem79 = new Problem79();
        char[][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(problem79.exist(matrix, word));
        System.out.println(problem79.exist(matrix, "ABCCEZ"));
    }
}
