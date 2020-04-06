/*
�����沨����ʾ��������ʽ��ֵ��

��Ч����������� +, -, *, / ��ÿ��������������������Ҳ��������һ���沨�����ʽ��

˵����

��������ֻ�����������֡�
�����沨�����ʽ������Ч�ġ����仰˵�����ʽ�ܻ�ó���Ч��ֵ�Ҳ����ڳ���Ϊ 0 �������
ʾ�� 1��

����: ["2", "1", "+", "3", "*"]
���: 9
����: ((2 + 1) * 3) = 9
ʾ�� 2��

����: ["4", "13", "5", "/", "+"]
���: 6
����: (4 + (13 / 5)) = 6
ʾ�� 3��

����: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
���: 22
����: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
*/
import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            switch(tokens[i]){
                case "+":{
                    String a = stack.pop();
                    String b = stack.pop();
                    stack.push((Integer.parseInt(b)+Integer.parseInt(a))+"");
                    break;
                }
                case "-":{
                    String a = stack.pop();
                    String b = stack.pop();
                    stack.push((Integer.parseInt(b)-Integer.parseInt(a))+"");
                    break;
                }
                case "*":{
                    String a = stack.pop();
                    String b = stack.pop();
                    stack.push((Integer.parseInt(b)*Integer.parseInt(a))+"");
                    break;
                }
                case "/":{
                    String a = stack.pop();
                    String b = stack.pop();
                    stack.push((Integer.parseInt(b)/Integer.parseInt(a))+"");
                    break;
                }
                default: stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}