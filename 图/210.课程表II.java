/*
�������ܹ��� n �ſ���Ҫѡ����Ϊ?0?��?n-1��

��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡�?���磬��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ�?1 ��������һ��ƥ������ʾ����: [0,1]

�����γ������Լ����ǵ��Ⱦ�������������Ϊ��ѧ�����пγ������ŵ�ѧϰ˳��

���ܻ��ж����ȷ��˳����ֻҪ����һ�־Ϳ����ˡ����������������пγ̣�����һ�������顣

ʾ��?1:

����: 2, [[1,0]] 
���: [0,1]
����:?�ܹ��� 2 �ſγ̡�Ҫѧϰ�γ� 1������Ҫ����ɿγ� 0����ˣ���ȷ�Ŀγ�˳��Ϊ [0,1] ��
ʾ��?2:

����: 4, [[1,0],[2,0],[3,1],[3,2]]
���: [0,1,2,3] or [0,2,1,3]
����:?�ܹ��� 4 �ſγ̡�Ҫѧϰ�γ� 3����Ӧ������ɿγ� 1 �Ϳγ� 2�����ҿγ� 1 �Ϳγ� 2 ��Ӧ�����ڿγ� 0 ֮��
?    ��ˣ�һ����ȷ�Ŀγ�˳����?[0,1,2,3] ����һ����ȷ��������?[0,2,1,3] ��

*/
import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++) list.add(new ArrayList<>());
        int[] inDegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0) queue.offer(i);
        }
        List<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()){
            int n = queue.poll();
            result.add(n);
            numCourses--;
            List<Integer> l = list.get(n);
            for(int c : l){
                inDegree[c]--;
                if(inDegree[c] == 0) queue.offer(c);
            }
        }
        int[] ans = new int[result.size()];
        for(int i=0;i<ans.length;i++) ans[i] = result.get(i);
        return numCourses == 0 ?  ans : new int[]{};
    }
}