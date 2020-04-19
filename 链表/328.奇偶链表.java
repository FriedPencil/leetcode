/*
����һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�

�볢��ʹ��ԭ���㷨��ɡ�����㷨�Ŀռ临�Ӷ�ӦΪ O(1)��ʱ�临�Ӷ�ӦΪ O(nodes)��nodes Ϊ�ڵ�������

ʾ�� 1:

����: 1->2->3->4->5->NULL
���: 1->3->5->2->4->NULL
ʾ�� 2:

����: 2->1->3->5->6->4->7->NULL 
���: 2->3->6->7->1->5->4->NULL
˵��:

Ӧ�����������ڵ��ż���ڵ�����˳��
����ĵ�һ���ڵ���Ϊ�����ڵ㣬�ڶ����ڵ���Ϊż���ڵ㣬�Դ����ơ�

*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
		//ע��Ӧ�ø�ȡһ��ͷ��һ������ͷ��
        ListNode temp = head;
        ListNode ehead = new ListNode(0);
        ehead.next = head;
        ListNode ohead = new ListNode(0);
        ohead.next = head;
        ListNode odd = ohead, even = ehead;

        int count = 1;
        while(temp != null){
            if((count & 1) == 1){
                odd.next = temp;
                odd = odd.next;
            }else{
                even.next = temp;
                even = even.next;
            }
            temp = temp.next;
            count++;
        }
        even.next = null;
        odd.next = ehead.next;
        return ohead.next;
    }
}