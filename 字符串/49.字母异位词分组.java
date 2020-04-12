/*
����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

ʾ��:

����: ["eat", "tea", "tan", "ate", "nat", "bat"],
���:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
˵����

���������ΪСд��ĸ��
�����Ǵ������˳��

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
            String key = String.valueOf(cstr); //Ҫ֪���Ĳ���
            if(!map.containsKey(key)) map.put(key,new ArrayList<String>());
            map.get(key).add(s);
        }
        result.addAll(map.values()); //Ҫ֪���Ĳ���
        return result;
    }
}