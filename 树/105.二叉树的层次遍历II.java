/*
����һ����������������ڵ�ֵ�Ե����ϵĲ�α����� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����

���磺
���������� [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
�������Ե����ϵĲ�α���Ϊ��

[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        queue.add(root);
        TreeNode t;
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            while(size!=0){
                t=queue.poll();
                size--;
                list.add(t.val);
                if(t.left != null)  queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
            lists.add(0,list);
        }
        return lists;
    }   
}