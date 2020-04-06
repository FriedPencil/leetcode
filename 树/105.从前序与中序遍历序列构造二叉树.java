/*
����һ������ǰ�������������������������

ע��:
����Լ�������û���ظ���Ԫ�ء�

���磬����

ǰ����� preorder =?[3,9,20,15,7]
������� inorder = [9,3,15,20,7]
�������µĶ�������

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
        if(ps > pe || is > ie) return null; //ע�����
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