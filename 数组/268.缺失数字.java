/*
����һ������ 0, 1, 2, ..., n �� n ���������У��ҳ� 0 .. n ��û�г����������е��Ǹ�����

ʾ�� 1:

����: [3,0,1]
���: 2
ʾ�� 2:

����: [9,6,4,2,3,5,7,0,1]
���: 8
*/
//��ϣ�����Ȳ�������ͣ�������ַ�������
class Solution {
    public int missingNumber(int[] nums) {
        int it = 0;
        int extra = nums.length;
        int temp;
        while(it<nums.length){
            if(nums[it] != -1 && nums[it] != it){
                if(nums[it] == nums.length){
                    extra = nums[it];
                    nums[it] = -1;
                }
                else{
                    temp = nums[nums[it]];
                    nums[nums[it]] = nums[it];
                    nums[it] = temp;
                }
                continue;
            }
            else it++;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == -1) return i;
        }
        return extra;
    }
}