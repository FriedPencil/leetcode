/*
给定一个包括?n 个整数的数组?nums?和 一个目标值?target。找出?nums?中的三个整数，使得它们的和与?target?最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

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