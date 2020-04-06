/*
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11

解：遍历时，用数组存储经历的节点值，对每个节点，逐个往前统计数组和，找到就计数加1。
*/
class Solution {
    public int pathSum(TreeNode root, int sum) {
        int[] path = new int[1000];
        return pathFind(root,sum,path,0);
    }
    public int pathFind(TreeNode root,int sum,int[] path, int p){
        if(root == null) return 0;
        int n = 0;
        path[p] = root.val;
        int count = 0;
        for(int i = p;i>=0;i--){
           count += path[i];
           if(count == sum) n++;
        }
        int n1 = pathFind(root.left,sum,path,p+1);
        int n2 = pathFind(root.right,sum,path,p+1);
        return n+n1+n2;
    }
}