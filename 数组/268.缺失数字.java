/*
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8
*/
//哈希法，等差数列求和，异或。三种方法均可
class Solution {
    public int missingNumber(int[] nums) {
        int it = 0;
        int extra = nums.length;
        int temp;
        while(it<nums.length){
            if(nums[it] != -1 && nums[it] != it){
                if(nums[it] == nums.length){
                    extra = nums[it];
                    nums[it] = -1;
                }
                else{
                    temp = nums[nums[it]];
                    nums[nums[it]] = nums[it];
                    nums[it] = temp;
                }
                continue;
            }
            else it++;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == -1) return i;
        }
        return extra;
    }
}