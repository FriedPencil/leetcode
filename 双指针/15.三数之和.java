/*
����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��ʹ��?a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣

ע�⣺���в����԰����ظ�����Ԫ�顣

?

ʾ����

�������� nums = [-1, 0, 1, 2, -1, -4]��

����Ҫ�����Ԫ�鼯��Ϊ��
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