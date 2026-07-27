class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 先执行一次横纵各扫一次
        int n = board.length;
        for (int row = 0; row < n; row++) {
            HashSet<Character> hs = new HashSet<>();
            for (int col = 0; col < n; col++) {
                char val = board[row][col];
                if (val == '.') {
                    continue;
                }
                if (hs.contains(val)) {
                    return false;
                }
                hs.add(val);
            }
        }
        for (int col = 0; col < n; col++) {
            HashSet<Character> hs1 = new HashSet<>();
            for (int row = 0; row < n; row++) {
                char val = board[row][col];
                if (val == '.') {
                    continue;
                }
                if (hs1.contains(val)) {
                    return false;
                }
                hs1.add(val);
            }
        }
        for (int startRow = 0; startRow < n; startRow += 3) {
            for (int startCol = 0; startCol < n; startCol += 3) {
                HashSet<Character> hs = new HashSet<>();
                for (int row = startRow; row < startRow + 3; row++) {
                    for (int col = startCol; col < startCol + 3; col++) {
                        char value = board[row][col];

                        if (value == '.') {
                            continue;
                        }

                        if (!hs.add(value)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
