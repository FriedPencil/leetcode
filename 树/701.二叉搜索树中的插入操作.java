/*
����������������BST���ĸ��ڵ��Ҫ�������е�ֵ����ֵ��������������� ���ز��������������ĸ��ڵ㡣 ��֤ԭʼ�����������в�������ֵ��

ע�⣬���ܴ��ڶ�����Ч�Ĳ��뷽ʽ��ֻҪ���ڲ�����Ա���Ϊ�������������ɡ� ����Է���������Ч�Ľ����

����, 

��������������:

        4
       / \
      2   7
     / \
    1   3

�� �����ֵ: 5
����Է����������������:

         4
       /   \
      2     7
     / \   /
    1   3 5
���������Ҳ����Ч��:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
		  */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        insert(root,new TreeNode(val));
        return root;
    }
    public void insert(TreeNode root,TreeNode node){
        if(node.val < root.val){
            if(root.left == null) root.left = node;
            else insert(root.left,node);
        }else if(node.val > root.val){
            if(root.right == null) root.right = node;
            else insert(root.right,node);
        }
    }
}		  