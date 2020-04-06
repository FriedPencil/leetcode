/*
����һ���ǿն����������������·���͡�

�����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣

ʾ�� 1:

����: [1,2,3]

       1
      / \
     2   3

���: 6
ʾ��?2:

����: [-10,9,20,null,null,15,7]

?  -10
? ?/ \
? 9 ?20
? ? / ?\
? ?15 ? 7

���: 42

*/
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxFind(root);
        return max;
    }
    public int maxFind(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(maxFind(root.left),0); //ע������и����Ļ����Ͳ�ȡ�����Ժ�0�Ƚϡ�
        int right = Math.max(maxFind(root.right),0);
        max = Math.max((root.val + left + right),max);
        return root.val + Math.max(left,right);
    }
}