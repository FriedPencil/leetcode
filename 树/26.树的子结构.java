/*
�������ö�����A��B���ж�B�ǲ���A���ӽṹ��(Լ��������������һ�������ӽṹ)

B��A���ӽṹ�� �� A���г��ֺ�B��ͬ�Ľṹ�ͽڵ�ֵ��

����:
�������� A:

? ? ?3
? ? / \
? ?4 ? 5
? / \
?1 ? 2
�������� B��

? ?4?
? /
?1
���� true����Ϊ B �� A ��һ������ӵ����ͬ�Ľṹ�ͽڵ�ֵ��

ʾ�� 1��

���룺A = [1,2,3], B = [3,1]
�����false
ʾ�� 2��

���룺A = [3,4,5,1,2], B = [4,1]
�����true

*/
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return isSub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public boolean isSub(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && isSub(A.left,B.left) && isSub(A.right,B.right);
    }
}