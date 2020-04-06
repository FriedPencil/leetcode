/*
����һ�������Ǹ������� m?x?n?�������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��

˵����ÿ��ֻ�����»��������ƶ�һ����

ʾ��:

����:
[
? [1,3,1],
  [1,5,1],
  [4,2,1]
]
���: 7
����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��

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