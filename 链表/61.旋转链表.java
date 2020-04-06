/*
����һ��������ת����������ÿ���ڵ������ƶ�?k?��λ�ã�����?k?�ǷǸ�����

ʾ��?1:

����: 1->2->3->4->5->NULL, k = 2
���: 4->5->1->2->3->NULL
����:
������ת 1 ��: 5->1->2->3->4->NULL
������ת 2 ��: 4->5->1->2->3->NULL
ʾ��?2:

����: 0->1->2->NULL, k = 4
���: 2->0->1->NULL
����:
������ת 1 ��: 2->0->1->NULL
������ת 2 ��: 1->2->0->NULL
������ת 3 ��:?0->1->2->NULL
������ת 4 ��:?2->0->1->NULL

*/
//�е���������Ӧ���ȼ���������Ȼ����ģ��
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
         if(head == null || head.next == null || k == 0) return head;//�߽�
         int length = 0;
         ListNode temp = head;
         for(int i=0;i<k;i++){
             if(temp.next != null) temp = temp.next;
             else temp = head;
         }
         if(temp == head) return head;//ע�ⲻ��ת�����
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