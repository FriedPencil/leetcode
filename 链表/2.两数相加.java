/*
��������?�ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ���?����?�ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢?һλ?���֡�

��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�

�����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��

ʾ����

���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
�����7 -> 0 -> 8
ԭ��342 + 465 = 807

*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int bit = 0, carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            bit = sum % 10;
            temp.next = new ListNode(bit);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        if(l1 == null) temp.next = l2;
        if(l2 == null) temp.next = l1;
   
        while(temp.next != null && carry > 0){ //һ��ʼ����1+99�����������Ҫѭ���жϣ�������һ�����ж�
            temp = temp.next;
            int sum = temp.val + carry;
            temp.val = sum % 10;
            carry = sum / 10;
        }
        if(carry > 0) temp.next = new ListNode(1);
        
        return head.next;
    }
}