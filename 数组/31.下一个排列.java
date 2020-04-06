/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

解：从后往前搜索，找到第一个降序位置，定位较小的那个，这么一来后续的序列就是非降序，然后重新从后往前搜索，找到第一个大于定位位置的，交换，然后定位位置后面逆序。
比如：158476531-定位4，然后从后往前搜索到5，交换4,5，得 158576431，然后5后面逆序，158513467.
如果找不到降序，直接全体逆序即可。
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i-1>=0 && nums[i-1] >= nums[i]) i--;
        if(i>0){
            i--;
            int j = nums.length-1;
            while(nums[j] <= nums[i]) j--;
            swap(nums,i,j);
            reverse(nums,i+1);
        }else reverse(nums,i);
    }
    public void reverse(int[] nums,int start){
        int end = nums.length-1;
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
