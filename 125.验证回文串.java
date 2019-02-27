/*
����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��

˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���

ʾ�� 1:

����: "A man, a plan, a canal: Panama"
���: true
ʾ�� 2:

����: "race a car"
���: false
*/
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if((c>='0' && c<='9') || (c>='a' && c<='z')){
                sb.append(c);
            }
        }
        int i=0,j=sb.length()-1;
        while(i<j){
            if(sb.charAt(i) == sb.charAt(j) || Math.abs(sb.charAt(i)-sb.charAt(j)) == 32){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}