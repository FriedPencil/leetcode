/*
����һ����������������ڵ�ֵ�ľ���β�α����������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���

���磺
����������?[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
���ؾ���β�α������£�

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