/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
*/
class Solution {
    public int firstUniqChar(String s) {
        int[] hash = new int[256];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)]==1) return i;
        }
        return -1;
    }
}