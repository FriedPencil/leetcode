/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder =?[3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] inorder,int ps,int pe,int is,int ie){
        if(ps > pe || is > ie) return null; //注意别忘
        int value = preorder[ps];
        TreeNode root = new TreeNode(value);
        int i=0;
        for(i=0;inorder[i] != value;i++){

        }
        root.left = build(preorder,inorder,ps+1,ps+i-is,is,i-1);
        root.right = build(preorder,inorder,ps+i-is+1,pe,i+1,ie);
        return root;
    }
}