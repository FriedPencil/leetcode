/*
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

解：先排高的，以整数对的第二个数为索引，然后按顺序把低的插入，插入位置依然是整数对的第二个数。
*/
import java.util.*;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2)->{
            if(o1[0] == o2[0]) return o1[1]-o2[1];
            else return o2[0]-o1[0];
        });
        List<int[]> list = new LinkedList<>();
        for(int[] p:people){
            list.add(p[1],p);
        }
        return list.toArray(new int[people.length][2]);
    }
}