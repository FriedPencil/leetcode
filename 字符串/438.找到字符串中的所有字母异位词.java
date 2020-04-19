/*
给定一个字符串?s?和一个非空字符串?p，找到?s?中所有是?p?的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串?s?和 p?的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例?1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
?示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

*/
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[26];
        for(int i=0;i<p.length();i++) hash[p.charAt(i)-'a']++;
        int i=0,j=p.length()-1;
        while(j<s.length()){
            int[] temp = Arrays.copyOf(hash,26);     
            for(int k=i;k<=j;k++){
                char c = s.charAt(k);
                if(temp[c-'a'] == 0) break;
                else{
                    temp[c-'a']--;
                    if(k == j) list.add(i);
                }
            }
            i++;
            j++;
        }
        return list;
    }
}

/*
更优化的算法700ms->14ms
*/
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[26];
        for(int i=0;i<p.length();i++) hash[p.charAt(i)-'a']++;
        int i=0,j=0;
        while(i < s.length() && j < s.length()){
            char c = s.charAt(j);
            if(hash[c-'a'] == 0){
                if(i == j){ //用于判断是根本不存在的字符还是存在但个数不符合，此处为根本不存在
                    i++;
                    j++;
                }else{ //此处为存在但是个数不符合
                    hash[s.charAt(i)-'a']++;
                    i++;  
                }
            }
            else{
                hash[c-'a']--;
                j++;
            }
            if(j-i == p.length()){
                list.add(i);
                hash[s.charAt(i)-'a']++;
                i++;
            } 
        }
        return list;
    }
}