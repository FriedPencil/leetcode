/*
��дһ�������������ַ��������е������ǰ׺��

��������ڹ���ǰ׺�����ؿ��ַ��� ""��

ʾ�� 1:

����: ["flower","flow","flight"]
���: "fl"
ʾ�� 2:

����: ["dog","racecar","car"]
���: ""
����: ���벻���ڹ���ǰ׺��
˵��:

��������ֻ����Сд��ĸ a-z ��
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String minString=strs[0];
        for(int i=0;i<strs.length;i++){
            minString = minString.length()<strs[i].length()?minString:strs[i];
        }
        String temp;
        boolean flag = false;
        while(!flag){
            for(int i=0;i<strs.length;i++){
                temp = strs[i].substring(0,minString.length());
                if (!temp.equals(minString)) break;
                if (i == strs.length-1) flag = true;
            }
            if (flag == false) minString = minString.substring(0,minString.length()-1);
        }
        if(minString.length() == 0) return "";
        return minString;
    }
}