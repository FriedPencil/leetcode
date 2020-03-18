/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0) return list;
        for(int i=1;i<=rowIndex;i++){
            long Cni_1 = list.get(i-1);
            int Cn_i = (int) ( Cni_1 * (rowIndex-i+1) / i);
            list.add(Cn_i);
        }
        return list;
    }
}