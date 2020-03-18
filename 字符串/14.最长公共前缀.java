/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String minString=strs[0];
        for(int i=0;i<strs.length;i++){
            minString = minString.length()<strs[i].length()?minString:strs[i];
        }
        String temp;
        boolean flag = false;
        while(!flag){
            for(int i=0;i<strs.length;i++){
                temp = strs[i].substring(0,minString.length());
                if (!temp.equals(minString)) break;
                if (i == strs.length-1) flag = true;
            }
            if (flag == false) minString = minString.substring(0,minString.length()-1);
        }
        if(minString.length() == 0) return "";
        return minString;
    }
}