/*
�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������

ʾ�� 1:

����: 121
���: true
ʾ�� 2:

����: -121
���: false
����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
ʾ�� 3:

����: 10
���: false
����: ���������, Ϊ 01 �����������һ����������
����:

���ܲ�������תΪ�ַ�����������������
*/
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || x %10 == 0 && x!=0) return false;
        int remainder = 0;
        int newNum = 0;
        while( x > newNum ){
            remainder = x%10;
            x /= 10;
            newNum = newNum * 10 +remainder;
        }
        if ( x == newNum || x == newNum/10  ) return true;
        else return false;
    }
}