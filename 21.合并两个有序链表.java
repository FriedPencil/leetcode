/*
��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ� 

ʾ����

���룺1->2->4, 1->3->4
�����1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) return l2;
        else if(l1 != null && l2 == null) return l1;
        else if(l1 == null && l2 == null) return null;
        ListNode l;
        if (l1.val < l2.val){
            l = new ListNode(l1.val);
            l1 = l1.next;
        }
        else{
            l = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode temp = l;
        while(l1 != null && l2 != null){
            if ( l1.val < l2.val ){
                temp.next = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) temp.next = l2;
        else if(l2 == null) temp.next = l1;
        return l;
    }
}