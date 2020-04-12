/*
ʵ��?pow(x, n)?�������� x �� n ���ݺ�����

ʾ�� 1:

����: 2.00000, 10
���: 1024.00000
ʾ��?2:

����: 2.10000, 3
���: 9.26100
ʾ��?3:

����: 2.00000, -2
���: 0.25000
����: 2-2 = 1/22 = 1/4 = 0.25
˵��:

-100.0 <?x?< 100.0
n?�� 32 λ�з�������������ֵ��Χ��?[?231,?231?? 1] ��

*/
class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(x == 1.0) return x;
        return n > 0 ? cal(x,n) : 1/cal(x,-1 * ((long)n)); //ע��-2147483648��Ϊ�����ᳬ��int�ķ�Χ��
    }
    public double cal(double x, long n){
        if(n == 1) return x;
        double ans = cal(x,n>>1);
        ans *= ans;
        if((n & 1) == 1) ans *= x;
        return ans;
    }
}