/*
����һ����������дһ���������ж����Ƿ��� 2 ���ݴη���

ʾ�� 1:

����: 1
���: true
����: 20 = 1
ʾ�� 2:

����: 16
���: true
����: 24 = 16
ʾ�� 3:

����: 218
���: false
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false; 
        if((n&n-1)==0) return true; 
        return false;
    }
}