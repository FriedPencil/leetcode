/*
给你一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，使得?a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

?

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        Arrays.sort(nums);
        int k=0,i=k+1,j=nums.length-1;
        while(k<nums.length){
          while(i < j){
              int sum = nums[k] + nums[i] + nums[j];
              if(sum < 0){
                  while(i+1 < j && nums[i+1] == nums[i])i++;
                  i++;
              }else if(sum > 0){
                  while(i < j-1 && nums[j-1] == nums[j])j--;
                  j--;
              }else{
                  list = new ArrayList<>();
                  list.add(nums[k]);list.add(nums[i]);list.add(nums[j]);
                  result.add(list); 
                  while(i+1 < j && nums[i+1] == nums[i])i++;
                  i++;
                  while(i < j-1 && nums[j-1] == nums[j])j--;
                  j--;
              }
          }
          while(k+1 < nums.length && nums[k+1] == nums[k]) k++;
          k++;
          i = k+1;
          j = nums.length-1;
        }
        return result;
    }
}