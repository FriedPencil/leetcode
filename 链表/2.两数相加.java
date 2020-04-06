/*
给出两个?非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照?逆序?的方式存储的，并且它们的每个节点只能存储?一位?数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0?开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

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
   
        while(temp.next != null && carry > 0){ //一开始忽略1+99的情况，所以要循环判断，而不是一次性判断
            temp = temp.next;
            int sum = temp.val + carry;
            temp.val = sum % 10;
            carry = sum / 10;
        }
        if(carry > 0) temp.next = new ListNode(1);
        
        return head.next;
    }
}