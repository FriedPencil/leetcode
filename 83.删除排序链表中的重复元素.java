/*
����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�

ʾ�� 1:

����: 1->1->2
���: 1->2
ʾ�� 2:

����: 1->1->2->3->3
���: 1->2->3
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode temp = head;
        ListNode cursor = head;
        do{
            do{
                 cursor = cursor.next;
            }while(cursor != null && cursor.val == temp.val);
            temp.next = cursor;
            temp = temp.next;
        }while(temp != null);
        return head;
    }
}