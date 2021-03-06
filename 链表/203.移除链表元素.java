/*
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
             head = head.next;
        }
        if(head == null) return null;
        ListNode it = head;
        while(it != null && it.next != null){
            if(it.next.val == val){
               it.next = it.next.next;
                continue;
            }
            it = it.next;
        }
        return head;
    }
}