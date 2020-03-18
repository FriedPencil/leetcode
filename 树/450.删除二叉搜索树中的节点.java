/*
����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е� key ��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ����£��ĸ��ڵ�����á�

һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺

�����ҵ���Ҫɾ���Ľڵ㣻
����ҵ��ˣ�ɾ������
˵���� Ҫ���㷨ʱ�临�Ӷ�Ϊ O(h)��h Ϊ���ĸ߶ȡ�

ʾ��:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

������Ҫɾ���Ľڵ�ֵ�� 3���������������ҵ� 3 ����ڵ㣬Ȼ��ɾ������

һ����ȷ�Ĵ��� [5,4,6,2,null,null,7], ����ͼ��ʾ��

    5
   / \
  4   6
 /     \
2       7

��һ����ȷ���� [5,2,6,null,4,null,7]��

    5
   / \
  2   6
   \   \
    4   7
	*/
	/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode parent = null;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key){
            if(root.right == null && root.left == null){
                if(parent == null) return null;
                if(parent.left == root) parent.left = null;
                if(parent.right == root) parent.right = null;
            }else if(root.right == null){
                root.val = root.left.val;
                TreeNode node = root.left;
                root.left = node.left;
                root.right = node.right;
            }else if(root.left == null){
                root.val = root.right.val;
                TreeNode node = root.right;
                root.left = node.left;
                root.right = node.right;
            }else{
                int val = successor(root);
                parent = root;
                deleteNode(root,val);
                root.val = val;
            }
        }
        else if(root.val < key){        
           parent = root;
           deleteNode(root.right,key);
        }
        else {
           parent = root;
           deleteNode(root.left,key);
        }
        return root;
    }
    public int successor(TreeNode root){
        if(root.right == null) return root.val;
        TreeNode node = root.right;
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }
    
    


}