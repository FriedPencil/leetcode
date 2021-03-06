/*
给定一个包含非负整数的 m?x?n?网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
? [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

*/
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int m=Integer.MAX_VALUE,n=Integer.MAX_VALUE;
                if(i-1>=0) m = grid[i][j] + dp[i-1][j];
                if(j-1>=0) n = grid[i][j] + dp[i][j-1];
                dp[i][j] = Math.min(m,n);
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}