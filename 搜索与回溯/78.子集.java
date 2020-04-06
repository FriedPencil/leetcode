/*
给定一组不含重复元素的整数数组?nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
? [1],
? [2],
? [1,2,3],
? [1,3],
? [2,3],
? [1,2],
? []
]

*/
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for(int i=0;i<=nums.length;i++){
            sub(nums,new ArrayList<Integer>(),i,0);
        }
        return result;
    }
    public void sub(int[] nums, List<Integer> list, int k, int first){
        if(list.size() == k) result.add(new ArrayList(list));
        for(int i=first;i<nums.length;i++){
            list.add(nums[i]);
            sub(nums,list,k,i+1);
            list.remove(list.size()-1);
        }
    }
}