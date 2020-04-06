/*
����ÿ�� ���� �б�����������һ���б���Ӧλ�õ��������Ҫ�ٵȴ�����¶ȲŻ����߳������յ����������֮�󶼲������ߣ����ڸ�λ����?0 �����档

���磬����һ���б�?temperatures = [73, 74, 75, 71, 69, 72, 76, 73]��������Ӧ����?[1, 1, 4, 2, 1, 1, 0, 0]��

��ʾ������ �б��ȵķ�Χ��?[1, 30000]��ÿ�����µ�ֵ�ľ�Ϊ���϶ȣ�������?[30, 100]?��Χ�ڵ�������

*/
import java.util.Stack;
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int t = stack.peek();
                stack.pop();
                result[t] = i-t;
            }
            stack.push(i);
        }
        return result;
    }
}