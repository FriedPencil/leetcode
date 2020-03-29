/*
合并?k?个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
? 1->4->5,
? 1->3->4,
? 2->6
]
输出: 1->1->2->3->4->4->5->6

*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeList(lists,0,lists.length-1);
    }
    public ListNode mergeList(ListNode[] lists, int start, int end){
        ListNode list = lists[start];
        int mid = (start+end)/2;
        if(start < end){
            ListNode list1 = mergeList(lists,start,mid);
            ListNode list2 = mergeList(lists,mid+1,end);
            list = merge(list1,list2);
        }
        return list;
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        if(list1 == null) temp.next = list2;
        if(list2 == null) temp.next = list1;
        return head.next;
    }
}
