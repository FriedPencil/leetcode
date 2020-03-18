/*
����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ��: 
�������¶��������Լ�Ŀ��� sum = 22��

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}