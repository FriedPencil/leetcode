/*
����һ��������дһ���������ж����Ƿ��� 3 ���ݴη���

ʾ�� 1:

����: 27
���: true
ʾ�� 2:

����: 0
���: false
ʾ�� 3:

����: 9
���: true
ʾ�� 4:

����: 45
���: false
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        int power = (int)(Math.log(Integer.MAX_VALUE)/Math.log(3));
        int factor = (int)Math.pow(3,power);
        return factor % n == 0;
    }
}