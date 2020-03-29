/*
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
*/
//统计字母数量，如果是偶数则计数，如果是奇数则只计其中一个，剩下的奇数统统记为其减一的数量。
class Solution {
    public int longestPalindrome(String s) {
        int[] letter = new int[256];
        for(int i=0;i<s.length();i++){
            letter[s.charAt(i)]++;
        }
        int ans = 0;
        for(int i=0;i<256;i++){
            if(letter[i] != 0){
                ans += letter[i]/2 * 2;
                if((letter[i] & 1) == 1 && (ans & 1) == 0) ans++; 
            }
        }
        return ans;
    }
}