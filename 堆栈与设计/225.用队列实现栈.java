/*
ʹ�ö���ʵ��ջ�����в�����

push(x) -- Ԫ�� x ��ջ
pop() -- �Ƴ�ջ��Ԫ��
top() -- ��ȡջ��Ԫ��
empty() -- ����ջ�Ƿ�Ϊ��
ע��:

��ֻ��ʹ�ö��еĻ�������-- Ҳ���� push to back, peek/pop from front, size, �� is empty ��Щ�����ǺϷ��ġ�
����ʹ�õ�����Ҳ��֧�ֶ��С� �����ʹ�� list ���� deque��˫�˶��У���ģ��һ������ , ֻҪ�Ǳ�׼�Ķ��в������ɡ�
����Լ������в���������Ч�ģ�����, ��һ���յ�ջ������� pop ���� top ��������
*/
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(q1.isEmpty()&&q2.isEmpty()) q1.add(x);
        else if(q1.isEmpty()) q2.add(x);
        else q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> qe,qf;
        if(q1.isEmpty()){
            qe = q1;
            qf = q2;
        }
        else{
            qe = q2;
            qf = q1;
        }
        while(qf.size() != 1){
            qe.add(qf.poll());
        }
        return qf.poll();
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> qe,qf;
        if(q1.isEmpty()){
            qe = q1;
            qf = q2;
        }
        else{
            qe = q2;
            qf = q1;
        }
        while(qf.size() != 1){
            qe.add(qf.poll());
        }
        int res = qf.poll();
        qe.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();
    }
}