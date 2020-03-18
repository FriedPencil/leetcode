/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设?s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1 = find(s,i,i);
            int len2 = find(s,i,i+1);
            int ans = Math.max(len1,len2);
            if(ans > end-start+1){
                start = i-(ans-1)/2;
                end = i+ans/2;
            }
        }
        return s.substring(start,end+1);

    }
    public int find(String s,int start,int end){
        while(start >= 0 && end < s.length()){
            if(s.charAt(start) == s.charAt(end)){
                start--;end++;
            }else break;
        }
        return end-start-1;
    }
}