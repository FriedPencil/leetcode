/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

*/
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0) return result;
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] cstr = s.toCharArray();
            Arrays.sort(cstr);
            String key = String.valueOf(cstr); //要知道的操作
            if(!map.containsKey(key)) map.put(key,new ArrayList<String>());
            map.get(key).add(s);
        }
        result.addAll(map.values()); //要知道的操作
        return result;
    }
}