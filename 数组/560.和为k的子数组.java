/*
����һ�����������һ������?k������Ҫ�ҵ��������к�Ϊ?k?��������������ĸ�����

ʾ�� 1 :

����:nums = [1,1,1], k = 2
���: 2 , [1,1] �� [1,1] Ϊ���ֲ�ͬ�������
˵�� :

����ĳ���Ϊ [1, 20,000]��
������Ԫ�صķ�Χ�� [-1000, 1000] ��������?k?�ķ�Χ��?[-1e7, 1e7]��

*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }
}