/*

请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode tail = head;
        int size = 1;
        while(tail.next != null){
            size++;
            tail = tail.next;
        }
        tail.next = head;
        ListNode temp;
        while(size > 0){
             if(tail.val == head.val){
                 temp = head;
                 while(temp.next!=tail) temp=temp.next;
                 temp.next = head.next;
                 tail = temp;
                 head = temp.next;
                 size -=2;
             }
             else return false;
        }
        return true;
    }
}