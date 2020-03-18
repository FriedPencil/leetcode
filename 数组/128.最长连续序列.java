/*

给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

*/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(int n : nums) set.add(n);
        for(int n : nums){
            if(!set.contains(n-1)){
                int count = 1;
                int num = n;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                result = Math.max(result,count);
            }
        }
        return result;
    }
}