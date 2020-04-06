/*
����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�

����㷨ʱ�临�Ӷȱ����� O(log n) ����

��������в�����Ŀ��ֵ������ [-1, -1]��

ʾ�� 1:

����: nums = [5,7,7,8,8,10], target = 8
���: [3,4]
ʾ�� 2:

����: nums = [5,7,7,8,8,10], target = 6
���: [-1,-1]
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