/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l = new ArrayList<String>();
        if(root == null) return l;
        String s = "" + root.val;
        if(root.left != null) fun(l,s,root.left);
        if(root.right != null) fun(l,s,root.right);
        if(root.left == null && root.right == null) l.add(s);
        return l;
    }
    public void fun(List l,String s,TreeNode root){
        s = s + "->" + root.val;
        String os = s;
        if(root.left == null && root.right==null) l.add(s);
        if(root.left != null) {
            fun(l,s,root.left);
            s = os;
        }
        if(root.right != null){
            fun(l,s,root.right);
            s = os;
        }
    }
}