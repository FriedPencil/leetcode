/*
����һ�鲻���ظ�Ԫ�ص���������?nums�����ظ��������п��ܵ��Ӽ����ݼ�����

˵�����⼯���ܰ����ظ����Ӽ���

ʾ��:

����: nums = [1,2,3]
���:
[
  [3],
? [1],
? [2],
? [1,2,3],
? [1,3],
? [2,3],
? [1,2],
? []
]

*/
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for(int i=0;i<=nums.length;i++){
            sub(nums,new ArrayList<Integer>(),i,0);
        }
        return result;
    }
    public void sub(int[] nums, List<Integer> list, int k, int first){
        if(list.size() == k) result.add(new ArrayList(list));
        for(int i=first;i<nums.length;i++){
            list.add(nums[i]);
            sub(nums,list,k,i+1);
            list.remove(list.size()-1);
        }
    }
}