/*
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例?2:

输入: [-10,9,20,null,null,15,7]

?  -10
? ?/ \
? 9 ?20
? ? / ?\
? ?15 ? 7

输出: 42

*/
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxFind(root);
        return max;
    }
    public int maxFind(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(maxFind(root.left),0); //注意如果有负数的话，就不取，所以和0比较。
        int right = Math.max(maxFind(root.right),0);
        max = Math.max((root.val + left + right),max);
        return root.val + Math.max(left,right);
    }
}