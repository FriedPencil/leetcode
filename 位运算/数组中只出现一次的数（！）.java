/*
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

?

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1

*/
//对每个数的每一位，统计其是否为1，对每一位的统计量，如果能被3整除，说明只一次的数字在这个位上是1,这样就可以算出这个数的每一位是否是1.
class Solution {
    public int singleNumber(int[] nums) {
        int count = 0;
        int result = 0;
        int bit = 1;
        for(int i=0;i<32;i++){
            count = 0;
            for(int j : nums){
                if( (j & bit) != 0) count++;
            }
            bit <<= 1;
            if(count % 3 != 0){
                result += (1<<i);
            }
        }
        return result;
    }
}