/*
����һ������ļ��ϣ���ϲ������ص������䡣

ʾ�� 1:

����: [[1,3],[2,6],[8,10],[15,18]]
���: [[1,6],[8,10],[15,18]]
����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
ʾ��?2:

����: [[1,4],[4,5]]
���: [[1,5]]
����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣

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
                int[] arr = new int[]{arr1[0],Math.max(arr2[1],arr1[1])}; //ע�������������������
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