/*
给定?n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。?感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

*/
//关键在于每个点的蓄水量等于其左右两侧最高点的较小值减去当前点高度。暴力法可解
//此处用双指针存储。
class Solution {
    public int trap(int[] height) {
        int left=0,right = height.length-1;
        int ans = 0;
        int maxLeft =0, maxRight = 0;
        while(left < right){
            if(height[left] < height[right]){ //注意是点高度不是max高度
                maxLeft = Math.max(maxLeft,height[left]);
                if(maxLeft - height[left] >0 ) ans += maxLeft - height[left];
                left++;
            }else{
                maxRight = Math.max(maxRight,height[right]);
                if(maxRight - height[right] >0) ans += maxRight - height[right];
                right--;
            }
        }
        return ans;
    }
}