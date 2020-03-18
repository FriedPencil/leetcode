/*

���ж�һ�������Ƿ�Ϊ��������

ʾ�� 1:

����: 1->2
���: false
ʾ�� 2:

����: 1->2->2->1
���: true
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