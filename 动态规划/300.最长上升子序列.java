/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是?[2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为?O(n2) 。

*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0; //因为初始为1，所以空要为0
        int[] dp = new int[nums.length];
        int max = 1; //注意初始为1
        for(int i=0;i<dp.length;i++) dp[i] = 1; //注意初始为1
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] > nums[i]){
                    dp[j] = Math.max(dp[j],dp[i]+1);
                    max = Math.max(max,dp[j]);
                } 
            }
        }
        return max;
    }
}