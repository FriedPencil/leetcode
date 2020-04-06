/*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例?2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

*/
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        LinkedList<int[]> list = new LinkedList<>();
        ArrayList<int[]> l = new ArrayList<>();
        for(int[] arr : intervals) list.add(arr);
        list.sort((o1,o2)->{return o1[0]-o2[0];});
        while(list.size() >= 2){
            int[] arr1 = list.getFirst();
            list.removeFirst();
            int[] arr2 = list.getFirst();
            list.removeFirst();
            if(arr1[1] >= arr2[0]){
                int[] arr = new int[]{arr1[0],Math.max(arr2[1],arr1[1])}; //注意区间整个包含的情况
                list.addFirst(arr);
            }else{
                l.add(arr1);
                list.addFirst(arr2);
            }
        }
        int[] arr = list.getFirst();
        l.add(arr);
        int[][] result = new int[l.size()][2];
        for(int i=0;i<result.length;i++){
            result[i][0] = l.get(i)[0];
            result[i][1] = l.get(i)[1];
        }
        return result;
    
    }
}