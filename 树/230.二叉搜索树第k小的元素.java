/*
给定一个二叉搜索树，编写一个函数?kthSmallest?来查找其中第?k?个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
?  2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3

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