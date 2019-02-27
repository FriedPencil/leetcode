/*
����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������

�����У�һ�ø߶�ƽ�����������Ϊ��

һ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������1��

ʾ�� 1:

���������� [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
���� true ��

ʾ�� 2:

���������� [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
���� false ��
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            int rh,lh;
            if(t.left == null) lh = 0;
            else{
                lh = height(t.left);
                q.add(t.left);
            }
            if(t.right == null) rh = 0;
            else{
                rh = height(t.right);
                q.add(t.right);
            }
            if(Math.abs(lh-rh) > 1) return false;
        }
        return true;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        int m = height(root.left);
        int n = height(root.right);
        return m>n?m+1:n+1;
    }
}