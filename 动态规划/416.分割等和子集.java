/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
?

示例?2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.

解：本质上是N数之和的问题，就成了要正好放满的背包问题。
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if((sum & 1) == 1) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        if(nums[0] <= target) dp[nums[0]] = true; //如果只有一个物品，只能放满容量为其值的背包，注意要小于目标值。
        for(int i=1;i<nums.length;i++){
            for(int j=target;j>=0;j--){
                if(dp[target]) return true; //这个最终结果值一旦为true，就不可能再变为false，所以可以直接返回
                if(j == nums[i]) dp[j] = true;//注意正好一个物品放满的情况
                else if(j > nums[i]){
                    dp[j] = dp[j] || dp[j-nums[i]]; //状态转移，此物不放或者此物放
                }else break;
            }
        }
        return dp[target];
    }
}