/*
����һ������ (32 λ�з�������)�����дһ���������ж����Ƿ��� 4 ���ݴη���

ʾ�� 1:

����: 16
���: true
ʾ�� 2:

����: 5
���: false
*/
class Solution {
    public boolean isPowerOfFour(int num) {
        return (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}