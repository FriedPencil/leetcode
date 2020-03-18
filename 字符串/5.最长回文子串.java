/*
����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ���?s ����󳤶�Ϊ 1000��

ʾ�� 1��

����: "babad"
���: "bab"
ע��: "aba" Ҳ��һ����Ч�𰸡�
ʾ�� 2��

����: "cbbd"
���: "bb"

*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1 = find(s,i,i);
            int len2 = find(s,i,i+1);
            int ans = Math.max(len1,len2);
            if(ans > end-start+1){
                start = i-(ans-1)/2;
                end = i+ans/2;
            }
        }
        return s.substring(start,end+1);

    }
    public int find(String s,int start,int end){
        while(start >= 0 && end < s.length()){
            if(s.charAt(start) == s.charAt(end)){
                start--;end++;
            }else break;
        }
        return end-start-1;
    }
}