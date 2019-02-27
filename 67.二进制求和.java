/*
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
*/
class Solution {
    public String addBinary(String a, String b) {
        if( a.length() == 0) {return b;}
        if( b.length() == 0) {return a;}
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        StringBuffer s = new StringBuffer();
        while(i >= 0 || j >= 0 || carry != 0) {
            if(i >= 0) {
                carry += a.charAt(i)-'0';
                i--;
            }
            if(j >= 0) {
                carry += b.charAt(j)-'0';
                j--;
            }
            s.insert(0,carry % 2);
            carry /= 2;
        }
        return s.toString();
    }
}