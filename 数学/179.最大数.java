/*
����һ��Ǹ������������������ǵ�˳��ʹ֮���һ������������

ʾ�� 1:

����: [10,2]
���: 210
ʾ��?2:

����: [3,30,34,5,9]
���: 9534330
˵��: ���������ܷǳ�����������Ҫ����һ���ַ���������������

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
        if(queue.peek().equals("0")) return "0"; //ע��ֻ��0�����
        while(!queue.isEmpty()){
            s += queue.poll();
        }
        return s;
    }
}