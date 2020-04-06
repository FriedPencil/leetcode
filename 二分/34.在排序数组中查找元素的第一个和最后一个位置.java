/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = left(nums,target);
        result[1] = right(nums,target);
        return result;
    }
    public int left(int[] nums,int target){
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] < target) start = mid+1;
            else if(nums[mid] > target) end = mid-1;
            else end = mid-1;
        }
        if(start >= nums.length || nums[start] != target ) return -1;
        else return start;
    }
    public int right(int[] nums,int target){
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] < target) start = mid+1;
            else if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        if(end < 0 || nums[end] != target ) return -1;
        else return end;
    }
}