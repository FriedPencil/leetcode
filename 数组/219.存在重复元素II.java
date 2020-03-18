/*
����һ�����������һ������ k���ж��������Ƿ����������ͬ������ i �� j��ʹ�� nums [i] = nums [j]������ i �� j �Ĳ�ľ���ֵ���Ϊ k��

ʾ�� 1:

����: nums = [1,2,3,1], k = 3
���: true
ʾ�� 2:

����: nums = [1,0,1,1], k = 1
���: true
ʾ�� 3:

����: nums = [1,2,3,1,2,3], k = 2
���: false
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                if(Math.abs(hm.get(nums[i])-i)<=k) return true;
                else{
                    hm.put(nums[i],i);
                }
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return false;
    }
}