/*
����һ������������?2-9?���ַ����������������ܱ�ʾ����ĸ��ϡ�

�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��



ʾ��:

���룺"23"
�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

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