/*
��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�

����һ����������?nums������ nums[i] �� nums[i+1]���ҵ���ֵԪ�ز�������������

������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�

����Լ���?nums[-1] = nums[n] = -�ޡ�

ʾ�� 1:

����: nums = [1,2,3,1]
���: 2
����: 3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
ʾ��?2:

����: nums = [1,2,1,3,5,6,4]
���: 1 �� 5 
����: ��ĺ������Է������� 1�����ֵԪ��Ϊ 2��
?    ���߷������� 5�� ���ֵԪ��Ϊ 6��

*/
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid+1]) right = mid;
            else left = mid+1; 
        }
        return left;
    }
}