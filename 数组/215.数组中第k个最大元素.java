/*
��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�

ʾ�� 1:

����: [3,2,1,5,6,4] �� k = 2
���: 5
ʾ��?2:

����: [3,2,3,1,2,4,5,5,6] �� k = 4
���: 4
˵��:

����Լ��� k ������Ч�ģ��� 1 �� k �� ����ĳ��ȡ�

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