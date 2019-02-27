/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。
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