/*
����һ������ɾ������ĵ�����?n?���ڵ㣬���ҷ��������ͷ��㡣

ʾ����

����һ������: 1->2->3->4->5, �� n = 2.

��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
˵����

������ n?��֤����Ч�ġ�

*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode fast = phead, slow = phead;
        for(int i=0;i<n;i++) fast = fast.next;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return phead.next;
    }
}