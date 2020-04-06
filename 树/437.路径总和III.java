/*
����һ��������������ÿ����㶼�����һ������ֵ��

�ҳ�·���͵��ڸ�����ֵ��·��������

·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��

������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������

ʾ����

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

���� 3���͵��� 8 ��·����:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11

�⣺����ʱ��������洢�����Ľڵ�ֵ����ÿ���ڵ㣬�����ǰͳ������ͣ��ҵ��ͼ�����1��
*/
class Solution {
    public int pathSum(TreeNode root, int sum) {
        int[] path = new int[1000];
        return pathFind(root,sum,path,0);
    }
    public int pathFind(TreeNode root,int sum,int[] path, int p){
        if(root == null) return 0;
        int n = 0;
        path[p] = root.val;
        int count = 0;
        for(int i = p;i>=0;i--){
           count += path[i];
           if(count == sum) n++;
        }
        int n1 = pathFind(root.left,sum,path,p+1);
        int n2 = pathFind(root.right,sum,path,p+1);
        return n+n1+n2;
    }
}