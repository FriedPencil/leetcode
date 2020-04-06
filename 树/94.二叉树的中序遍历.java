/*
����һ����������������������?������

ʾ��:

����: [1,null,2,3]
   1
    \
     2
    /
   3

���: [1,3,2]

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