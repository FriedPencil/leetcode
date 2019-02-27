/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [-2^31,  2^31-1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
*/

class Solution {
    public int reverse(int x) {
        long lx = (long)x;
        String num = String.valueOf(Math.abs(lx));
        Stack<Character> stack = new Stack();
        for(int i=0;i<num.length();i++){
            stack.push(num.charAt(i));
        }
        String newNum = "";
        for(int i=0;i<num.length();i++){
            newNum += stack.pop();
        }
        long lnum = Long.parseLong(newNum);
        if(lnum < -2<<30 || lnum > (2<<30)-1)
            return 0;
        else if(x<0)
            return 0-Integer.parseInt(newNum);
        else
            return Integer.parseInt(newNum);
    }
}