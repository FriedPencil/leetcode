/*
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".
示例 2:

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
*/
class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            int a = count(s,i,i);
            int b = count(s,i,i+1);
            result += (a+b);
        }
        return result;
    }
    public int count(String s, int i, int j){
        int count = 0;
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}