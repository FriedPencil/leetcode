/*
����һ����������Сд��ĸ�Ϳո� ' ' ���ַ��������������һ�����ʵĳ��ȡ�

������������һ�����ʣ��뷵�� 0 ��

˵����һ��������ָ����ĸ��ɣ����������κοո���ַ�����

ʾ��:

����: "Hello World"
���: 5
*/
class Solution {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        if (ss.length == 0) return 0;
        return ss[ss.length-1].length();
    }
}