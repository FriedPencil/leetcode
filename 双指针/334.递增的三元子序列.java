/*
����һ��δ��������飬�ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�

��ѧ���ʽ����:

�������������?i, j, k,??������?0 �� i < j < k �� n-1��
ʹ��?arr[i] < arr[j] < arr[k] ������ true ;?���򷵻� false ��
˵��: Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1) ��

ʾ�� 1:

����: [1,2,3,4,5]
���: true
ʾ�� 2:

����: [5,4,3,2,1]
���: false

*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for(int i:nums){
            if(m1 >= i) m1 = i;
            else if(m2 >= i) m2 = i;
            else return true;
        } 
        return false;
    }
}