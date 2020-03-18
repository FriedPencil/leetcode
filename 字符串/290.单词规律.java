/*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。  
*/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map hm1 = new HashMap<>();
        Map hm2 = new HashMap<>();

        String[] s = str.split(" ");
        if(pattern.length() != s.length) return false;
        for(int i=0;i<s.length;i++){
            if (!hm1.containsKey(pattern.charAt(i))){
                hm1.put(pattern.charAt(i),s[i]);
            }
            else{
                if(!hm1.get(pattern.charAt(i)).equals(s[i])) return false; 
                //hm.get()返回的是object，不能用==比较
            }
            if (!hm2.containsKey(s[i])){
                hm2.put(s[i],pattern.charAt(i));
            }
            else{
                if(!hm2.get(s[i]).equals(pattern.charAt(i))) return false;
            }
        }
        return true;
    }
}