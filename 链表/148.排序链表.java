/*
在?O(n?log?n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

*/
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head; //找链表中点，注意这里。
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list2 = slow.next;
        slow.next = null;
        ListNode list1 = sortList(head);
        list2 = sortList(list2);
        ListNode list = new ListNode(0);
        ListNode temp = list;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 == null) temp.next = list2;
        if(list2 == null) temp.next = list1;
        return list.next;
    }
}