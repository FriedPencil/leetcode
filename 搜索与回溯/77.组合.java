/*
������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�

ʾ��:

����:?n = 4, k = 2
���:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        fun(n,k,1);
        return result;
    }
    public void fun(int n, int k, int index){
        if(list.size() == k) result.add(new ArrayList<Integer>(list));
        for(int i=index;i<=n;i++){
            list.add(i);
            fun(n,k,i+1);
            list.remove(list.size()-1);
        }
    }
}