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
        // 进入小方格里，就不用逐行或者逐列扫了，直接把整个格子的数装进来
        for (int startRow = 0; startRow < n; startRow+=3){
            for (int startCol = 0; startCol<n; startCol+=3){
                // 每一个小格子，我们构建一个哈希set
                HashSet<Character> hs2 = new HashSet<>();
                // 开始对每个小格子的遍历
                for (int row = startRow; row<startRow+3; row++){
                    for (int col = startCol; col<startCol+3; col++){
                        char cur = board[row][col];
                        if (cur=='.'){
                            continue;
                        }
                        if (hs2.contains(cur)){
                            return false;
                        }
                        hs2.add(cur);
                    }
                }
            }
        }
        return true;
    }
}
