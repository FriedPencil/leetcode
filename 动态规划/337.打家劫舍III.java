/*
���ϴδ����һ���ֵ�֮���һȦ���ݺ�С͵�ַ�����һ���µĿ����Եĵ������������ֻ��һ����ڣ����ǳ�֮Ϊ�������� ���ˡ�����֮�⣬ÿ����������ֻ��һ��������������֮������һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö��������� �������ֱ�������ķ�����ͬһ�����ϱ���٣����ݽ��Զ�������

�����ڲ���������������£�С͵һ���ܹ���ȡ����߽�

ʾ�� 1:

����: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

���: 7 
����:?С͵һ���ܹ���ȡ����߽�� = 3 + 3 + 1 = 7.
ʾ�� 2:

����: [3,4,5,1,3,null,1]

?    3
    / \
   4   5
  / \   \ 
 1   3   1

���: 9
����:?С͵һ���ܹ���ȡ����߽��?= 4 + 5 = 9.

�⣺�ö�ά�����¼ÿ���ڵ�͵���ǲ�͵��Ǯ����
*/

class Solution {
    public int rob(TreeNode root) {
        int[] result = robFun(root);
        return Math.max(result[0],result[1]);
    }
    public int[] robFun(TreeNode root){
        int[] result = new int[2];
        if(root == null) return result;
        int[] left = robFun(root.left);
        int[] right = robFun(root.right);
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}