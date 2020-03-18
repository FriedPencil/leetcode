/*
����һ�����������ҳ�����С��ȡ�

��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ��:

���������� [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
����������С���  2.
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth=0;
        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            while(size != 0){
                TreeNode t  = q.poll();
                size--;
                if(t.left == null && t.right==null) return depth;
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
        }
        return 0;
    }
}