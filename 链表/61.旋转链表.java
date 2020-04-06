/*
给定一个链表，旋转链表，将链表每个节点向右移动?k?个位置，其中?k?是非负数。

示例?1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例?2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步:?0->1->2->NULL
向右旋转 4 步:?2->0->1->NULL

*/
//有点慢，还是应该先计算链表长度然后求模。
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
         if(head == null || head.next == null || k == 0) return head;//边界
         int length = 0;
         ListNode temp = head;
         for(int i=0;i<k;i++){
             if(temp.next != null) temp = temp.next;
             else temp = head;
         }
         if(temp == head) return head;//注意不旋转的情况
         ListNode point = head;
         while(temp.next != null){
             temp = temp.next;
             point = point.next;
         }
         ListNode newHead = point.next;
         point.next = null;
         temp.next = head;
         return newHead;
    }
}