/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/

/*思路
将数组中的每个数逐一加入HashMap,加入前检验目标值与加入值的差是否已存在，如果存在，这对应值与加入值就是我们要的答案
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int num;
        for(int i=0;i<nums.length;i++){
            num = target - nums[i];
            if(map.containsKey(num)){
                return new int[] {map.get(num),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }
}

