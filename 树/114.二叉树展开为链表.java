/*
����һ����������ԭ�ؽ���չ��Ϊ����

���磬����������

    1
   / \
  2   5
 / \   \
3   4   6
����չ��Ϊ��

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

�⣺���ô�������ĺ��������
*/
class Solution {
    TreeNode node = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = node;
        node = root;
    }
}