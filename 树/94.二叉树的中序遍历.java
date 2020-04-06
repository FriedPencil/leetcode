/*
给定一个二叉树，返回它的中序?遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

*/
import java.util.*;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.isEmpty()){
            while(stack.peek() != null) stack.push(stack.peek().left);
            stack.pop();
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                stack.push(node.right);
            }
        }
        return list;
    }
}