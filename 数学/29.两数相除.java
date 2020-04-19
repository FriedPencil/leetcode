/*
给定两个整数，被除数?dividend?和除数?divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数?dividend?除以除数?divisor?得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

?

示例?1:

输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
示例?2:

输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2
?

提示：

被除数和除数均为 32 位有符号整数。
除数不为?0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [?231,? 231?? 1]。本题中，如果除法结果溢出，则返回 231?? 1。

解：两数都取正，若a/b,减去b*（2的n次方），n能使结果小于a的一半，然后结果加上n，之后继续重来，直到a减到比b小为止。
由于最小负数转成正数会溢出，此处用long，如果不能用，就先加上一个b的绝对值，让其绝对值变小，然后继续上述操作，最后结果记得调整+1或-1。
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