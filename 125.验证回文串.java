/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
*/
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if((c>='0' && c<='9') || (c>='a' && c<='z')){
                sb.append(c);
            }
        }
        int i=0,j=sb.length()-1;
        while(i<j){
            if(sb.charAt(i) == sb.charAt(j) || Math.abs(sb.charAt(i)-sb.charAt(j)) == 32){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}