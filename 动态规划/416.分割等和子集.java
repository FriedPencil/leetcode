/*
����һ��ֻ�����������ķǿ����顣�Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�

ע��:

ÿ�������е�Ԫ�ز��ᳬ�� 100
����Ĵ�С���ᳬ�� 200
ʾ�� 1:

����: [1, 5, 11, 5]

���: true

����: ������Էָ�� [1, 5, 5] �� [11].
?

ʾ��?2:

����: [1, 2, 3, 5]

���: false

����: ���鲻�ָܷ������Ԫ�غ���ȵ��Ӽ�.

�⣺��������N��֮�͵����⣬�ͳ���Ҫ���÷����ı������⡣
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if((sum & 1) == 1) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        if(nums[0] <= target) dp[nums[0]] = true; //���ֻ��һ����Ʒ��ֻ�ܷ�������Ϊ��ֵ�ı�����ע��ҪС��Ŀ��ֵ��
        for(int i=1;i<nums.length;i++){
            for(int j=target;j>=0;j--){
                if(dp[target]) return true; //������ս��ֵһ��Ϊtrue���Ͳ������ٱ�Ϊfalse�����Կ���ֱ�ӷ���
                if(j == nums[i]) dp[j] = true;//ע������һ����Ʒ���������
                else if(j > nums[i]){
                    dp[j] = dp[j] || dp[j-nums[i]]; //״̬ת�ƣ����ﲻ�Ż��ߴ����
                }else break;
            }
        }
        return dp[target];
    }
}