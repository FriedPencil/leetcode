/*
����������?n���ҵ����ɸ���ȫƽ����������?1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�

ʾ��?1:

����: n = 12
���: 3 
����: 12 = 4 + 4 + 4.
ʾ�� 2:

����: n = 13
���: 2
����: 13 = 4 + 9.

�⣺ö����ȫƽ������Ȼ��Ӳ��������
*/
class Solution {
    public int numSquares(int n) {
        int max = (int)Math.sqrt(n);
        int[] num = new int[n];
        for(int i=0;i<num.length;i++) num[i] = (i+1)*(i+1);
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<num.length;j++){
                if(i-num[j] >= 0) dp[i] = Math.min(dp[i],dp[i-num[j]]+1);
            }
        }
        return dp[n];
    }
}