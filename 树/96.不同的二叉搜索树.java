/*
给定一个整数 n，求以?1 ...?n?为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

*/
class Solution {
    public int numTrees(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                result[i] += result[j] * result[i-j-1];
            }
        }
        return result[n];
    }
}