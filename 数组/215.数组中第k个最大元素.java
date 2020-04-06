/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例?2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return find(nums,nums.length-k,0,nums.length-1);
    }
    public int find(int[] nums,int k,int low,int high){
        int p = partition(nums,low,high);
        if(p == k) return nums[p];
        else if(p > k)  return find(nums,k,low,p-1);
        else return find(nums,k,p+1,high);
    }
    public int partition(int[] nums,int low ,int high){
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] >= temp) high--;
            nums[low] = nums[high];
            while(low < high && nums[low] <= temp) low++;
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}