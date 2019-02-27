/*
���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����

����Ϊ�ǿ��ַ�����ֻ�������� 1 �� 0��

ʾ�� 1:

����: a = "11", b = "1"
���: "100"
ʾ�� 2:

����: a = "1010", b = "1011"
���: "10101"
*/
class Solution {
    public String addBinary(String a, String b) {
        if( a.length() == 0) {return b;}
        if( b.length() == 0) {return a;}
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        StringBuffer s = new StringBuffer();
        while(i >= 0 || j >= 0 || carry != 0) {
            if(i >= 0) {
                carry += a.charAt(i)-'0';
                i--;
            }
            if(j >= 0) {
                carry += b.charAt(j)-'0';
                j--;
            }
            s.insert(0,carry % 2);
            carry /= 2;
        }
        return s.toString();
    }
}