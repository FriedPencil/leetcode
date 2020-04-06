/*
给定一个链表，删除链表的倒数第?n?个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n?保证是有效的。

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