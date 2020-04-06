/*
ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�

�����������һ����������У��������������г���С�����У����������У���

����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1

�⣺�Ӻ���ǰ�������ҵ���һ������λ�ã���λ��С���Ǹ�����ôһ�����������о��Ƿǽ���Ȼ�����´Ӻ���ǰ�������ҵ���һ�����ڶ�λλ�õģ�������Ȼ��λλ�ú�������
���磺158476531-��λ4��Ȼ��Ӻ���ǰ������5������4,5���� 158576431��Ȼ��5��������158513467.
����Ҳ�������ֱ��ȫ�����򼴿ɡ�
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i-1>=0 && nums[i-1] >= nums[i]) i--;
        if(i>0){
            i--;
            int j = nums.length-1;
            while(nums[j] <= nums[i]) j--;
            swap(nums,i,j);
            reverse(nums,i+1);
        }else reverse(nums,i);
    }
    public void reverse(int[] nums,int start){
        int end = nums.length-1;
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
