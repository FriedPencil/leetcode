/*
��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��

������������ x �� y����������֮��ĺ������롣

ע�⣺
0 �� x, y < 231.

ʾ��:

����: x = 1, y = 4

���: 2

����:
1   (0 0 0 1)
4   (0 1 0 0)
       ��   ��

����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�

*/
class Solution {
    public int hammingDistance(int x, int y) {
        int diff = x^y;
        int count = 0;
        while(diff != 0){ //�����������1�ĸ������Ż�д��
            count++;
            diff = diff & (diff-1);
        }
        return count;
    }
}