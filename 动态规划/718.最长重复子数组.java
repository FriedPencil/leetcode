/*
��������������?A?��?B?���������������й����ġ��������������ĳ��ȡ�

ʾ�� 1:

����:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
���: 3
����: 
������Ĺ����������� [3, 2, 1]��
˵��:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100

*/
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[1001][1001];
        int max = 0;
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
}