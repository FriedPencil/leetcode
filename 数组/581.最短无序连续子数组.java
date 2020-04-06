/*
����һ���������飬����ҪѰ��һ�������������飬���������������������������ô�������鶼���Ϊ��������

���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�

ʾ�� 1:

����: [2, 6, 4, 8, 10, 9, 15]
���: 5
����: ��ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
˵�� :

��������鳤�ȷ�Χ��?[1, 10,000]��
�����������ܰ����ظ�Ԫ��?�������������˼��<=��

˼·������һ�飬�ҵ�����ʧ����������Сֵ�����ֵ��Ȼ������ң��ҵ���һ��������Сֵ�ģ�������߽磬���ҵ����ҵ���һ��С�����ֵ�ģ������ұ߽硣
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
           if(nums[i+1]<nums[i]){
               min = Math.min(min,nums[i+1]);
               max = Math.max(max,nums[i]);
           }
        }
        int right = 0, left = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > min){
                left = i;
                break;
            }
        }
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j] < max){
                right = j;
                break;
            }
        }
        return right > left ? right-left+1:0;
    }
}
