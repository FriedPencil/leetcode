/*
����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���

���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ��Ϊ�ǲ�ͬ���Ӵ���

ʾ�� 1:

����: "abc"
���: 3
����: ���������Ӵ�: "a", "b", "c".
ʾ�� 2:

����: "aaa"
���: 6
˵��: 6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa".
*/
class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            int a = count(s,i,i);
            int b = count(s,i,i+1);
            result += (a+b);
        }
        return result;
    }
    public int count(String s, int i, int j){
        int count = 0;
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}