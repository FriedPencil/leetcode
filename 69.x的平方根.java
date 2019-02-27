/*
ʵ�� int sqrt(int x) ������

���㲢���� x ��ƽ���������� x �ǷǸ�������

���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��

ʾ�� 1:

����: 4
���: 2
ʾ�� 2:

����: 8
���: 2
˵��: 8 ��ƽ������ 2.82842..., 
     ���ڷ���������������С�����ֽ�����ȥ��
*/
class Solution {
    public int mySqrt(int x) {
        if(x <=1 ) return x;
        int left = 0,right = x;
        while(true){
            int mid =left + (right - left) / 2;
            if(right - left == 1){
                if(right * right == x) return right;
                else return left;
            }
            if(x / mid >= mid) left = mid;
            else right = mid;
        }
    }
}