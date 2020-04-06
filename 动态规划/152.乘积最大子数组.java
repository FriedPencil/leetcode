/*
����һ���������� nums?�������ҳ������г˻��������������飨�������������ٰ���һ�����֣���

?

ʾ�� 1:

����: [2,3,-2,4]
���: 6
����:?������ [2,3] �����˻� 6��
ʾ�� 2:

����: [-2,0,-1]
���: 0
����:?�������Ϊ 2, ��Ϊ [-2,-1] ���������顣

*/
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int ma = 1, mi = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0) {
                int temp = ma;
                ma = mi;
                mi = temp;
            }
            ma = Math.max(nums[i],nums[i] * ma);
            mi = Math.min(nums[i],nums[i] * mi);

            max = Math.max(max,ma);
        }
        return max;
    }
}