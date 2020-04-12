/*
����һ������������ַ������������������ַ�����

�������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string  �����ظ� k �Ρ�ע�� k ��֤Ϊ��������

�������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�

���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻�������?3a?��?2[4]?�����롣

ʾ��:

s = "3[a]2[bc]", ���� "aaabcbc".
s = "3[a2[c]]", ���� "accaccacc".
s = "2[abc]3[cd]ef", ���� "abcabccdcdcdef".

*/
import java.util.*;
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c != ']' || stack.isEmpty()) stack.push(c);
            else{
                String single = "";
                while(!stack.isEmpty() && stack.peek() != '[') single = stack.pop() + single;
                stack.pop();
                String n = "";
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') n = stack.pop() + n;
                String str = "";
                for(int j=0;j<Integer.parseInt(n);j++) str += single;
                for(int j=0;j<str.length();j++) stack.push(str.charAt(j));
            }
        }
        String result = "";
        while(!stack.isEmpty()) result = stack.pop() + result;
        return result;
    }
}