/*
����һ���ַ����������ת�ַ����е�ÿ�����ʡ�

 

ʾ�� 1��

����: "the sky is blue"
���: "blue is sky the"
ʾ�� 2��

����: "  hello world!  "
���: "world! hello"
����: �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
ʾ�� 3��

����: "a good   example"
���: "example good a"
����: ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 

˵����

�޿ո��ַ�����һ�����ʡ�
�����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
*/
class Solution {
    public String reverseWords(String s) {
        if(s.trim().equals("")) return "";
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
             if(!str[i].equals("")){
               sb.append(str[i]);
               if(i > 0) sb.append(" ");
             }
        }
        return sb.toString();
    }
}