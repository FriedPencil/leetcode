/*
����һ����������?nums�����������������С�

?

ʾ�� 1��

���룺nums = [5,2,3,1]
�����[1,2,3,5]
ʾ�� 2��

���룺nums = [5,1,1,2,0,0]
�����[0,0,1,1,2,5]

*/
class Solution {
    public int[] sortArray(int[] nums) {
        QuickSort(nums,0,nums.length-1);
        return nums;
    }
    public void QuickSort(int[] nums, int low, int high){
        if(low < high){
            int p = onceQuick(nums,low,high);
            QuickSort(nums,low,p-1);
            QuickSort(nums,p+1,high);
        }
    }
    public int onceQuick(int[] nums,int low,int high){
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