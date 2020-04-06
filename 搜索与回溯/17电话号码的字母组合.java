/*
给定一个仅包含数字?2-9?的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/
class Solution {
    HashMap<Character,String> map = new HashMap<>();
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");map.put('3',"def");map.put('4',"ghi");map.put('5',"jkl");
        map.put('6',"mno");map.put('7',"pqrs");map.put('8',"tuv");map.put('9',"wxyz");
        if(digits.length() ==0) return list;
        fun(digits,0,"");
        return list;
    }
    public void fun(String digits,int index,String s){
        if(index == digits.length()){
            list.add(s);
            return;
        }
        String str = map.get(digits.charAt(index));
        for(int i=0;i<str.length();i++){
            String temp = s + str.charAt(i);
            fun(digits,index+1,temp);
        }
    }
}