/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组?[0,1,2,4,5,6,7]?可能变为?[4,5,6,7,0,1,2]?)。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回?-1?。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是?O(log?n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例?2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] < nums[end]){
                end = mid;
            }else if(nums[mid] > nums[end]){
                start = mid+1;
            }else end--;
        }
        
        if(target >= nums[start] && target <= nums[nums.length-1]) end = nums.length-1; //如果空数组这里会出错，所以开头要判空。
        else{
            end = start-1;
            start = 0;
        }
		
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] > target) end = mid-1;
            else if(nums[mid] < target) start = mid+1;
            else return mid;
        }
        return -1;
    }
}