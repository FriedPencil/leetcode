/*
��дһ�������жϸ��������Ƿ�Ϊ������

��������ֻ���������� 2, 3, 5 ����������

ʾ�� 1:

����: 6
���: true
����: 6 = 2 �� 3
ʾ�� 2:

����: 8
���: true
����: 8 = 2 �� 2 �� 2
ʾ�� 3:

����: 14
���: false 
����: 14 ���ǳ�������Ϊ������������һ�������� 7��
*/
class Solution {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        while(num%2==0)
            num/=2;
        while(num%3==0)
            num/=3;
        while(num%5==0)
            num/=5;
        return num==1;
    }
}