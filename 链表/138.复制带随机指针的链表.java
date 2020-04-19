/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的?深拷贝。?

我们用一个由?n?个节点组成的链表来表示输入/输出中的链表。每个节点用一个?[val, random_index]?表示：

val：一个表示?Node.val?的整数。
random_index：随机指针指向的节点索引（范围从?0?到?n-1）；如果不指向任何节点，则为??null?。
?

示例 1：

输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：

输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：

输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。

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
            if(copyTemp.next != null) copyTemp.next = copyTemp.next.next; //注意这个节点会到达最后，所以要对next判空，而temp不会到达最后，所以不用。
            temp = temp.next;
            copyTemp = copyTemp.next;
        }
        return copy;
    }
}