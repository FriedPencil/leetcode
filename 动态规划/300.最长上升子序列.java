/*
����һ��������������飬�ҵ���������������еĳ��ȡ�

ʾ��:

����: [10,9,2,5,3,7,101,18]
���: 4 
����: ���������������?[2,3,7,101]�����ĳ����� 4��
˵��:

���ܻ��ж�������������е���ϣ���ֻ��Ҫ�����Ӧ�ĳ��ȼ��ɡ�
���㷨��ʱ�临�Ӷ�Ӧ��Ϊ?O(n2) ��

*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0; //��Ϊ��ʼΪ1�����Կ�ҪΪ0
        int[] dp = new int[nums.length];
        int max = 1; //ע���ʼΪ1
        for(int i=0;i<dp.length;i++) dp[i] = 1; //ע���ʼΪ1
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] > nums[i]){
                    dp[j] = Math.max(dp[j],dp[i]+1);
                    max = Math.max(max,dp[j]);
                } 
            }
        }
        return max;
    }
}