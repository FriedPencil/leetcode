/*
��һ������ nums �г�һ������ֻ����һ��֮�⣬�������ֶ����������Ρ����ҳ��Ǹ�ֻ����һ�ε����֡�

?

ʾ�� 1��

���룺nums = [3,4,3,3]
�����4
ʾ�� 2��

���룺nums = [9,1,7,9,7,9,7]
�����1

*/
//��ÿ������ÿһλ��ͳ�����Ƿ�Ϊ1����ÿһλ��ͳ����������ܱ�3������˵��ֻһ�ε����������λ����1,�����Ϳ�������������ÿһλ�Ƿ���1.
class Solution {
    public int singleNumber(int[] nums) {
        int count = 0;
        int result = 0;
        int bit = 1;
        for(int i=0;i<32;i++){
            count = 0;
            for(int j : nums){
                if( (j & bit) != 0) count++;
            }
            bit <<= 1;
            if(count % 3 != 0){
                result += (1<<i);
            }
        }
        return result;
    }
}