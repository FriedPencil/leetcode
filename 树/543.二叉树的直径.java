/*
����һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ�������㡣

ʾ�� :
����������

          1
         / \
        2   3
       / \     
      4   5    
����?3, ���ĳ�����·�� [4,2,1,3] ����?[5,2,1,3]��

ע�⣺�����֮���·��������������֮��ߵ���Ŀ��ʾ��

*/
class Solution {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return result;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        result = Math.max(result,left+right);
        return Math.max(left,right)+1;
    }
}
