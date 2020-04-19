/*
��������������������?dividend?�ͳ���?divisor�������������Ҫ��ʹ�ó˷��������� mod �������

���ر�����?dividend?���Գ���?divisor?�õ����̡�

���������Ľ��Ӧ����ȥ��truncate����С�����֣����磺truncate(8.345) = 8 �Լ� truncate(-2.7335) = -2

?

ʾ��?1:

����: dividend = 10, divisor = 3
���: 3
����: 10/3 = truncate(3.33333..) = truncate(3) = 3
ʾ��?2:

����: dividend = 7, divisor = -3
���: -2
����: 7/-3 = truncate(-2.33333..) = -2
?

��ʾ��

�������ͳ�����Ϊ 32 λ�з���������
������Ϊ?0��
�������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?231,? 231?? 1]�������У�����������������򷵻� 231?? 1��

�⣺������ȡ������a/b,��ȥb*��2��n�η�����n��ʹ���С��a��һ�룬Ȼ��������n��֮�����������ֱ��a������bСΪֹ��
������С����ת��������������˴���long����������ã����ȼ���һ��b�ľ���ֵ���������ֵ��С��Ȼ���������������������ǵõ���+1��-1��
*/
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = (long)dividend, b = (long)divisor;
        boolean flag = false;
        if(a < 0){
            a = -a;
            flag = !flag;
        }
        if(b < 0){
            b = -b;
            flag = !flag;
        }
        long result = 0;
        while(a >= b){
            long temp = b;
            long n = 1l;
            while(temp <= (a>>1l)){
                temp <<= 1l;
                n <<= 1l;
            }
            a -= temp;
            result += n;
        }
        int ans = (int)result;
        return flag ? -ans : ans;
    }
}