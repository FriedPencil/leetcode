/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode phead = new ListNode(0);
        ListNode pre = phead;
        ListNode start = head,end = head,nex = head;
        while(nex != null){
            for(int i=0;i<k-1;i++) {
                 end = end.next;
                 if(end == null) return phead.next;
            }
            nex = end.next;
            end.next = null;
            pre.next = reverse(start);
            pre = start;
            pre.next = nex;
            start = nex;
            end = nex;
        }
        return phead.next;
    }
    public ListNode reverse(ListNode node){
        if(node.next == null) return node;
        ListNode head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}