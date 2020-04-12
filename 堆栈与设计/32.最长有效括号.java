/*
����һ��ֻ���� '('?�� ')'?���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�

ʾ��?1:

����: "(()"
���: 2
����: ���Ч�����Ӵ�Ϊ "()"
ʾ�� 2:

����: ")()())"
���: 4
����: ���Ч�����Ӵ�Ϊ "()()"

*/
//��ס�ɣ��뵽��ջ�����Ǿ�����ô�����ǲ���
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else{
                    int length = i-stack.peek();
                    max = Math.max(length,max);
                }
            }
        }
        return max;
    }
}