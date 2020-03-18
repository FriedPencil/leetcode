/*
给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
示例 1:

输入: 1
输出: "A"
示例 2:

输入: 28
输出: "AB"
示例 3:

输入: 701
输出: "ZY"
*/
class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        int rem;
        while(n > 0){
            n--;
            rem=n%26;
            char c = (char)(rem+65);
            sb.append(c);
            n/=26;

        }
        String s =sb.reverse().toString();
        return s;
    }
}