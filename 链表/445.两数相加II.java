/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

?

进阶：

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

?

示例：

输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7

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
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){ //这里必须要对栈判空，是为了在一开始carry为0的时候能进入循环，其实到后循环主要由carry主导。
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