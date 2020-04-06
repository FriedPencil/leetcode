/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :

输入的数组长度范围在?[1, 10,000]。
输入的数组可能包含重复元素?，所以升序的意思是<=。

思路：遍历一遍，找到所有失序数字中最小值和最大值，然后从左到右，找到第一个大于最小值的，就是左边界，从右到左，找到第一个小于最大值的，就是右边界。
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
           if(nums[i+1]<nums[i]){
               min = Math.min(min,nums[i+1]);
               max = Math.max(max,nums[i]);
           }
        }
        int right = 0, left = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > min){
                left = i;
                break;
            }
        }
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j] < max){
                right = j;
                break;
            }
        }
        return right > left ? right-left+1:0;
    }
}
