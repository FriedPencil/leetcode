/*
给出?n?代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出?n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

解：搜素条件，左括号数量小于n，且右括号数量小于左括号数量。
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