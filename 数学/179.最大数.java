/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例?2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

*/
import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1,o2)->{
            String s1 = o1+o2;
            String s2 = o2+o1;
            return s2.compareTo(s1);
        });
        for(int i:nums) queue.offer("" + i);
        String s = "";
        if(queue.peek().equals("0")) return "0"; //注意只有0的情况
        while(!queue.isEmpty()){
            s += queue.poll();
        }
        return s;
    }
}