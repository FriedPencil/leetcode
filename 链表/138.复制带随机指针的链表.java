/*
����һ������ÿ���ڵ����һ���������ӵ����ָ�룬��ָ�����ָ�������е��κνڵ��սڵ㡣

Ҫ�󷵻���������?�����?

������һ����?n?���ڵ���ɵ���������ʾ����/����е�����ÿ���ڵ���һ��?[val, random_index]?��ʾ��

val��һ����ʾ?Node.val?��������
random_index�����ָ��ָ��Ľڵ���������Χ��?0?��?n-1���������ָ���κνڵ㣬��Ϊ??null?��
?

ʾ�� 1��

���룺head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
�����[[7,null],[13,0],[11,4],[10,2],[1,0]]
ʾ�� 2��

���룺head = [[1,1],[2,1]]
�����[[1,1],[2,1]]
ʾ�� 3��

���룺head = [[3,null],[3,0],[3,null]]
�����[[3,null],[3,0],[3,null]]
ʾ�� 4��

���룺head = []
�����[]
���ͣ�����������Ϊ�գ���ָ�룩����˷��� null��

*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = head;
        while(temp != null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        temp = head;
        while(temp != null){
            if(temp.random != null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        Node copy = temp.next;
        Node copyTemp = copy;
        while(temp != null){
            temp.next = temp.next.next;
            if(copyTemp.next != null) copyTemp.next = copyTemp.next.next; //ע������ڵ�ᵽ���������Ҫ��next�пգ���temp���ᵽ��������Բ��á�
            temp = temp.next;
            copyTemp = copyTemp.next;
        }
        return copy;
    }
}