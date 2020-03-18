/*
����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������

k ��һ��������������ֵС�ڻ��������ĳ��ȡ�

����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��

 

ʾ����

�����������1->2->3->4->5

�� k = 2 ʱ��Ӧ������: 2->1->4->3->5

�� k = 3 ʱ��Ӧ������: 3->2->1->4->5
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode phead = new ListNode(0);
        ListNode pre = phead;
        ListNode start = head,end = head,nex = head;
        while(nex != null){
            for(int i=0;i<k-1;i++) {
                 end = end.next;
                 if(end == null) return phead.next;
            }
            nex = end.next;
            end.next = null;
            pre.next = reverse(start);
            pre = start;
            pre.next = nex;
            start = nex;
            end = nex;
        }
        return phead.next;
    }
    public ListNode reverse(ListNode node){
        if(node.next == null) return node;
        ListNode head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}