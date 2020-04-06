/*
��ʹ�������?+ ��?-????????������������????????a?��b????????֮�͡�

ʾ�� 1:

����: a = 1, b = 2
���: 3
ʾ�� 2:

����: a = -2, b = 3
���: 1

*/
class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int sum = 0;
        do{
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while(carry != 0);
        return sum;
    }
}