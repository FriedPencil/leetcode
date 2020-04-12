/*
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树?[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

*/
import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        boolean flag = true;
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        odd.push(root);
        while(!odd.isEmpty() || !even.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(flag){
                while(!odd.isEmpty()){
                    TreeNode node = odd.pop();
                    list.add(node.val);
                    if(node.left != null) even.push(node.left);
                    if(node.right != null) even.push(node.right);
                }
            }else{
                while(!even.isEmpty()){
                    TreeNode node = even.pop();
                    list.add(node.val);
                    if(node.right != null) odd.push(node.right);
                    if(node.left != null) odd.push(node.left);
                }
            }
            result.add(list);
            flag = !flag;
        }
        return result;
    }
}