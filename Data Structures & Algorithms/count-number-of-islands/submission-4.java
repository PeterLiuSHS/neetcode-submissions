class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        for (int row = 0; row < grid.length; row++){
            for (int col =0; col<grid[0].length; col++){
                if (grid[row][col]=='1'){
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        if (row<0 || col<0 || row>=grid.length || col>=grid[0].length){
            return ; // 结束了
        }

        if (grid[row][col]=='0'){
            return ;// 也结束了，不用继续了
        }

        // 接下来就是元素等于1的情况了
        grid[row][col] = '0'; // 我们先把这个元素给改了

        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
}









