/*
����һ��������������Binary Search Tree��������ת����Ϊ�ۼ�����Greater Tree)��ʹ��ÿ���ڵ��ֵ��ԭ���Ľڵ�ֵ�������д������Ľڵ�ֵ֮�͡�

?

���磺

����: ԭʼ����������:
              5
            /   \
           2     13

���: ת��Ϊ�ۼ���:
             18
            /   \
          20     13

*/
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    public void convert(TreeNode root){
        if(root == null) return;
        convert(root.right);
        root.val += sum;
        sum = root.val;
        convert(root.left);
    }
}