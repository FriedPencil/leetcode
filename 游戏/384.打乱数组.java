/*
打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();

*/
class Solution {
    int[] arr;
    int[] origin;
    public Solution(int[] nums) {
        origin = nums;
        arr = new int[nums.length];
        System.arraycopy(nums,0,arr,0,nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuArr = new int[arr.length];
        Random r = new Random();
        for(int i=0;i<arr.length;i++){
            int index = r.nextInt(arr.length-i)+i; //注意生成某个区间内随机数的方法
            swap(arr,i,index);
            shuArr[i] = arr[i];
        }
        return shuArr;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */