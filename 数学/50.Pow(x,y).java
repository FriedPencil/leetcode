/*
实现?pow(x, n)?，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例?2:

输入: 2.10000, 3
输出: 9.26100
示例?3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 <?x?< 100.0
n?是 32 位有符号整数，其数值范围是?[?231,?231?? 1] 。

*/
class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(x == 1.0) return x;
        return n > 0 ? cal(x,n) : 1/cal(x,-1 * ((long)n)); //注意-2147483648变为正数会超出int的范围。
    }
    public double cal(double x, long n){
        if(n == 1) return x;
        double ans = cal(x,n>>1);
        ans *= ans;
        if((n & 1) == 1) ans *= x;
        return ans;
    }
}