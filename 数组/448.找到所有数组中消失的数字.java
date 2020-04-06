/*
����һ����Χ��? 1 �� a[i] �� n (?n = �����С ) �� �������飬�����е�Ԫ��һЩ���������Σ���һЩֻ����һ�Ρ�

�ҵ������� [1, n] ��Χ֮��û�г����������е����֡�

�����ڲ�ʹ�ö���ռ���ʱ�临�Ӷ�ΪO(n)�������������������? ����Լٶ����ص����鲻���ڶ���ռ��ڡ�

ʾ��:

����:
[4,3,2,7,8,2,3,1]

���:
[5,6]

*/
import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            while(nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp; 
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1) list.add(i+1);
        }
        return list;
    }
}