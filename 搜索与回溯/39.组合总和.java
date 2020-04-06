/*
����һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�

candidates?�е����ֿ����������ظ���ѡȡ��

˵����

�������֣�����?target��������������
�⼯���ܰ����ظ�����ϡ�?
ʾ��?1:

����: candidates = [2,3,6,7], target = 7,
����⼯Ϊ:
[
  [7],
  [2,2,3]
]
ʾ��?2:

����: candidates = [2,3,5], target = 8,
����⼯Ϊ:
[
? [2,2,2,2],
? [2,3,3],
? [3,5]
]

*/
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(candidates,target,0);
        return result;
    }
    public void find(int[] candidates,int target,int start){
        for(int i=start;i<candidates.length;i++){
            if(target-candidates[i] == 0){
                list.add(candidates[i]);
                result.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
                return;
            }else if(target-candidates[i] > 0){
                list.add(candidates[i]);
                find(candidates,target-candidates[i],i);
                list.remove(list.size()-1);
            }
            else break;
        }
    }
}