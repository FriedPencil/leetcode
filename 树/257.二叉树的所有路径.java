/*
����һ�����������������дӸ��ڵ㵽Ҷ�ӽڵ��·����

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ��:

����:

   1
 /   \
2     3
 \
  5

���: ["1->2->5", "1->3"]

����: ���и��ڵ㵽Ҷ�ӽڵ��·��Ϊ: 1->2->5, 1->3
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l = new ArrayList<String>();
        if(root == null) return l;
        String s = "" + root.val;
        if(root.left != null) fun(l,s,root.left);
        if(root.right != null) fun(l,s,root.right);
        if(root.left == null && root.right == null) l.add(s);
        return l;
    }
    public void fun(List l,String s,TreeNode root){
        s = s + "->" + root.val;
        String os = s;
        if(root.left == null && root.right==null) l.add(s);
        if(root.left != null) {
            fun(l,s,root.left);
            s = os;
        }
        if(root.right != null){
            fun(l,s,root.right);
            s = os;
        }
    }
}