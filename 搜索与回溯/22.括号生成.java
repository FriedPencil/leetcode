/*
����?n?�����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�

���磬����?n = 3�����ɽ��Ϊ��

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

�⣺��������������������С��n��������������С��������������
*/
import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        fun(list,"",0,0,n);
        return list;
    }
    public void fun(List<String> list,String str,int left,int right,int max){
        if(str.length() == max * 2){
            list.add(str);
            return;
        }
        if(left < max) fun(list,str+"(",left+1,right,max);
        if(right < left) fun(list,str+")",left,right+1,max);
    }
}