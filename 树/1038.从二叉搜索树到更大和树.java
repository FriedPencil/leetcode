/*
�������� ���� ���ĸ��ڵ㣬�ö������Ľڵ�ֵ������ͬ���޸Ķ�������ʹÿ���ڵ� node?����ֵ����ԭ���д��ڻ����?node.val?��ֵ֮�͡�

����һ�£�������������������Լ��������

�ڵ���������������� С�� �ڵ���Ľڵ㡣
�ڵ���������������� ���� �ڵ���Ľڵ㡣
��������Ҳ�����Ƕ�����������
?

ʾ����



���룺[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
�����[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
?

��ʾ��

���еĽڵ������� 1 �� 100 ֮�䡣
ÿ���ڵ��ֵ����?0 ��?100?֮�䡣
��������Ϊ������������
?

*/
class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
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