/*
����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��

��Ч�ַ��������㣺

�����ű�������ͬ���͵������űպϡ�
�����ű�������ȷ��˳��պϡ�
ע����ַ����ɱ���Ϊ����Ч�ַ�����

ʾ�� 1:

����: "()"
���: true
ʾ�� 2:

����: "()[]{}"
���: true
ʾ�� 3:

����: "(]"
���: false
ʾ�� 4:

����: "([)]"
���: false
ʾ�� 5:

����: "{[]}"
���: true
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        stack.push('0');
        for(int i=0;i<s.length();i++){
            if(stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
            else if(stack.peek() == '{' && s.charAt(i) == '}') stack.pop();
            else if(stack.peek() == '[' && s.charAt(i) == ']') stack.pop();
            else stack.push(s.charAt(i));
        }
        if (stack.peek() == '0') return true;
        else return false;
    }
}