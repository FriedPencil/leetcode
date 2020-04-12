/*
�����д���˳���һȺ��վ��һ�����С� ÿ������һ��������(h, k)��ʾ������h������˵���ߣ�k�����������ǰ������ߴ��ڻ����h�������� ��дһ���㷨���ؽ�������С�

ע�⣺
����������1100�ˡ�

ʾ��

����:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

���:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

�⣺���Ÿߵģ��������Եĵڶ�����Ϊ������Ȼ��˳��ѵ͵Ĳ��룬����λ����Ȼ�������Եĵڶ�������
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