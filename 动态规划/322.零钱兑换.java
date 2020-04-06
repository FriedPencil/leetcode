/*
������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����?-1��

ʾ��?1:

����: coins = [1, 2, 5], amount = 11
���: 3 
����: 11 = 5 + 5 + 1
ʾ�� 2:

����: coins = [2], amount = 3
���: -1
˵��:
�������Ϊÿ��Ӳ�ҵ����������޵ġ�

*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);//��ֵΪ���
        dp[0] = 0;//ע��amountΪ0��ʱ��
        for(int i=0;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i == coins[j]) dp[i] = 1;
                if(i-coins[j] > 0) dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}