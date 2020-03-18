/*
����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�

ʾ��:

����: [1,2,3]
���:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/
import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        perm(nums,0,nums.length-1);
        return result;
    }
    public void perm(int[] nums, int start,int end){
        if(start == end){
            for(int n:nums) list.add(n);
            result.add(new ArrayList(list));
            list.clear();
        }
        for(int i=start;i<=end;i++){
            swap(nums,start,i);
            perm(nums,start+1,end);
            swap(nums,start,i);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}