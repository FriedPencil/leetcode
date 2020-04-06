/*
����һ����������������дһ������?kthSmallest?���������е�?k?����С��Ԫ�ء�

˵����
����Լ��� k ������Ч�ģ�1 �� k �� ����������Ԫ�ظ�����

ʾ�� 1:

����: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
?  2
���: 1
ʾ�� 2:

����: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
���: 3

*/
class Solution {
    int count = 0;
    TreeNode node = null;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return node.val;
    }
    public void inOrder(TreeNode root,int k){
        if(root == null) return;
        inOrder(root.left,k);
        count++;
        if(count == k){
            node = root;
            return;
        } 
        inOrder(root.right,k);
    }
}