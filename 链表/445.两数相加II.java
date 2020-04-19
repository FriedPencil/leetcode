/*
�������� �ǿ� ���������������Ǹ��������������λλ������ʼλ�á����ǵ�ÿ���ڵ�ֻ�洢һλ���֡�����������ӻ᷵��һ���µ�����

����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��

?

���ף�

��������������޸ĸ���δ������仰˵���㲻�ܶ��б��еĽڵ���з�ת��

?

ʾ����

���룺(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
�����7 -> 8 -> 0 -> 7

*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode node = null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){ //�������Ҫ��ջ�пգ���Ϊ����һ��ʼcarryΪ0��ʱ���ܽ���ѭ������ʵ����ѭ����Ҫ��carry������
            int a = s1.isEmpty() ? 0 : s1.pop().val;
            int b = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = a + b + carry;
            carry = sum / 10;
            ListNode head = new ListNode(sum % 10);
            head.next = node;
            node = head;
        }
        return node;
    }
}