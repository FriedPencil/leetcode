/*
����һ�����������ж����Ƿ���һ����Ч�Ķ�����������

����һ��������������������������

�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
�ڵ��������ֻ�������ڵ�ǰ�ڵ������
�������������������������Ҳ�Ƕ�����������
ʾ��?1:

����:
    2
   / \
  1   3
���: true
ʾ��?2:

����:
    5
   / \
  1   4
?    / \
?   3   6
���: false
����: ����Ϊ: [5,1,4,null,null,3,6]��
?    ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��

*/
class Solution {
  public boolean helper(TreeNode node, Integer lower, Integer upper) {
    if (node == null) return true;

    int val = node.val;
    if (lower != null && val <= lower) return false;
    if (upper != null && val >= upper) return false;

    return helper(node.right, val, upper) && helper(node.left, lower, val);
  }
    public boolean isValidBST(TreeNode root) {
      return helper(root, null, null);
    }
}