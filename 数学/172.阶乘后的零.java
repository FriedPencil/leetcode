/*
����һ������ n������ n! ���β�������������

ʾ�� 1:

����: 3
���: 0
����: 3! = 6, β����û���㡣
ʾ�� 2:

����: 5
���: 1
����: 5! = 120, β������ 1 ����.
˵��: ���㷨��ʱ�临�Ӷ�ӦΪ O(log n) ��
*/
class Solution {
    public int trailingZeroes(int n) {
        int res=0;
        while(n>0){
            n /= 5;
            res += n;
        }
        return res;
    }
}