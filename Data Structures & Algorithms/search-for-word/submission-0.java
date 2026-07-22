class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, row, col, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, int position, String word) {
        if (position == word.length()) {
            return true;
        }

        if (row >= board.length || col >= board[0].length || row < 0 || col < 0) {
            return false;
        }

        char c = word.charAt(position);
        if (board[row][col] != c) {
            return false;
        }
        char org = board[row][col];
         
        board[row][col] = '#';
        boolean found = backtrack(board, row + 1, col, position + 1, word)
            || backtrack(board, row - 1, col, position + 1, word)
            || backtrack(board, row, col + 1, position + 1, word)
            || backtrack(board, row, col - 1, position + 1, word);
        board[row][col] = org;

        return found;
    }
}