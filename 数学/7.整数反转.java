/*
����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��

ʾ�� 1:

����: 123
���: 321
 ʾ�� 2:

����: -123
���: -321
ʾ�� 3:

����: 120
���: 21
ע��:

�������ǵĻ���ֻ�ܴ洢���� 32 λ���з���������������ֵ��ΧΪ [-2^31,  2^31-1]�������������裬�����ת�����������ô�ͷ��� 0��
*/

class Solution {
    public int reverse(int x) {
        long lx = (long)x;
        String num = String.valueOf(Math.abs(lx));
        Stack<Character> stack = new Stack();
        for(int i=0;i<num.length();i++){
            stack.push(num.charAt(i));
        }
        String newNum = "";
        for(int i=0;i<num.length();i++){
            newNum += stack.pop();
        }
        long lnum = Long.parseLong(newNum);
        if(lnum < -2<<30 || lnum > (2<<30)-1)
            return 0;
        else if(x<0)
            return 0-Integer.parseInt(newNum);
        else
            return Integer.parseInt(newNum);
    }
}