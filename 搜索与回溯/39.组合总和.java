/*
给定一个无重复元素的数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。

candidates?中的数字可以无限制重复被选取。

说明：

所有数字（包括?target）都是正整数。
解集不能包含重复的组合。?
示例?1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例?2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
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