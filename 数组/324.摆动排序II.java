/*
给定一个无序的数组?nums，将它重新排列成?nums[0] < nums[1] > nums[2] < nums[3]...?的顺序。

示例?1:

输入: nums = [1, 5, 1, 1, 6, 4]
输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
示例 2:

输入: nums = [1, 3, 2, 2, 3, 1]
输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
说明:
你可以假设所有输入都会得到有效的结果。


解：用快速选择找到中位数，然后按荷兰旗方法排成三部分，从中间裂开，两个数组然后倒序轮流插入。
*/
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums.length <= 1) return; //注意小于等于1，不然快速选择会失败
        int mid = find(nums,0,nums.length-1,nums.length/2); //注意中位数的选取，为长度/2,得到的数值直接是中位数索引。
        int left=0,right=nums.length-1,p=0;
        while(p <= right){
            if(nums[p] > mid){
                swap(nums,p,right);
                right--;
            }else if(nums[p] < mid){
                swap(nums,p,left);
                left++;
                p++;
            }else p++;
        }
        int[] result = new int[nums.length];
        for(int i=0;i<result.length;i++){
            if((i & 1) == 0) result[i] = nums[(nums.length-1)/2-i/2];
            else result[i] = nums[nums.length-1-i/2];
        }
        System.arraycopy(result,0,nums,0,result.length);
    }
    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
    public int find(int[] nums,int low,int high,int k){
        int p = partition(nums,low,high);
        if(p == k) return nums[p];
        else if(p > k)  return find(nums,low,p-1, k);
        else return find(nums,p+1,high,k);
    }
}