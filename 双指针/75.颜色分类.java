/*
����һ��������ɫ����ɫ����ɫ��һ��?n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�

�����У�����ʹ������ 0��?1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��

ע��:
����ʹ�ô�����е����������������⡣

ʾ��:

����: [2,0,2,1,1,0]
���: [0,0,1,1,2,2]
���ף�

һ��ֱ�۵Ľ��������ʹ�ü������������ɨ���㷨��
���ȣ����������0��1 �� 2 Ԫ�صĸ�����Ȼ����0��1��2��������д��ǰ���顣
�������һ����ʹ�ó����ռ��һ��ɨ���㷨��

*/
class Solution {
    public void sortColors(int[] nums) {
        int low = 0,high = nums.length-1, index = 0;
        while(index <= high){ //���ںżǵ�
            if(nums[index] == 2){ //���ﲻ�ø�index��1
                swap(nums,index,high);
                high--;
            }else if(nums[index] == 0){ //����Ҫ��index��1
                swap(nums,index,low);
                index++;
                low++;
            }else index++;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}