/*
给定一个只包含 '('?和 ')'?的字符串，找出最长的包含有效括号的子串的长度。

示例?1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

*/
//记住吧，想到用栈，但是具体怎么做还是不会
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else{
                    int length = i-stack.peek();
                    max = Math.max(length,max);
                }
            }
        }
        return max;
    }
}