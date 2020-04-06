/*
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

( ���磬����?[0,1,2,4,5,6,7]?���ܱ�Ϊ?[4,5,6,7,0,1,2]?)��

����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻�?-1?��

����Լ��������в������ظ���Ԫ�ء�

����㷨ʱ�临�Ӷȱ�����?O(log?n) ����

ʾ�� 1:

����: nums = [4,5,6,7,0,1,2], target = 0
���: 4
ʾ��?2:

����: nums = [4,5,6,7,0,1,2], target = 3
���: -1

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
        
        if(target >= nums[start] && target <= nums[nums.length-1]) end = nums.length-1; //��������������������Կ�ͷҪ�пա�
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