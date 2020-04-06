/*
给你一个整数数组 nums?，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。

?

示例 1:

输入: [2,3,-2,4]
输出: 6
解释:?子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释:?结果不能为 2, 因为 [-2,-1] 不是子数组。

*/
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int ma = 1, mi = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0) {
                int temp = ma;
                ma = mi;
                mi = temp;
            }
            ma = Math.max(nums[i],nums[i] * ma);
            mi = Math.min(nums[i],nums[i] * mi);

            max = Math.max(max,ma);
        }
        return max;
    }
}