/*
����һ������?n ������������?nums?�� һ��Ŀ��ֵ?target���ҳ�?nums?�е�����������ʹ�����ǵĺ���?target?��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�

���磬�������� nums = [-1��2��1��-4], �� target = 1.

�� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).

*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return sum;
                else if(sum < target) left++;
                else right--;
                int dif = Math.abs(sum-target);
                if(dif <= min){
                    min = dif;
                    result = sum;
                }                
            }
        }
        return result;
    }
}