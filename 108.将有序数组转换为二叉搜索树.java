/*
��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������

�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��

ʾ��:

������������: [-10,-3,0,5,9],

һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������

      0
     / \
   -3   9
   /   /
 -10  5
 */
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return build(nums,0,nums.length-1);
    }
    public TreeNode build(int[] nums,int left,int right){
        if(left > right) return null;
        int mid = (left+right)/2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = build(nums,left,mid-1);
        t.right = build(nums,mid+1,right);
        return t;
    }
}