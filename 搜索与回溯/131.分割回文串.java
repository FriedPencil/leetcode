/*
����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���

���� s ���п��ܵķָ����

ʾ��:

����:?"aab"
���:
[
  ["aa","b"],
  ["a","a","b"]
]

*/
import java.util.*;
class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        find(s,0,s.length()-1);
        return result;
    }
    public void find(String s,int start,int end){
        if(start > end){
            result.add(new ArrayList<>(list));
        }
        for(int i=start;i<=end;i++){
            if(!check(s,start,i)) continue;
            String temp = s.substring(start,i+1);
            list.add(temp);
            find(s,i+1,end);
            list.remove(list.size()-1);
        }

    }
    public boolean check(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else return false;
        }
        return true;
    }
}