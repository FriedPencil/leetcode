/*
����һ�����֣����ǰ������¹����������Ϊ�ַ�����0 ����� ��a�� ��1 ����� ��b����������11 ����� ��l����������25 ����� ��z����һ�����ֿ����ж�����롣����ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����

?

ʾ�� 1:

����: 12258
���: 5
����: 12258��5�ֲ�ͬ�ķ��룬�ֱ���"bccfi", "bwfi", "bczi", "mcfi"��"mzi"

*/
class Solution {
    public int translateNum(int num) {
        if(num <= 9) return 1;
        int tail = num % 100;
        if(tail <= 9 || tail > 25) return translateNum(num/10);
        return translateNum(num/10) + translateNum(num/100);
    }
}