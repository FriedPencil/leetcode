/*
给定正整数?n，找到若干个完全平方数（比如?1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例?1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

解：枚举完全平方数，然后按硬币问题做
*/
class Solution {
    public int numSquares(int n) {
        int max = (int)Math.sqrt(n);
        int[] num = new int[n];
        for(int i=0;i<num.length;i++) num[i] = (i+1)*(i+1);
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<num.length;j++){
                if(i-num[j] >= 0) dp[i] = Math.min(dp[i],dp[i-num[j]]+1);
            }
        }
        return dp[n];
    }
}