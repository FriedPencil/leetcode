/*
����һ���Ǹ��������飬a1, a2, ..., an, ��һ��Ŀ������S������������������?+?��?-�����������е�����һ���������㶼���Դ�?+?��?-��ѡ��һ�����������ǰ�档

���ؿ���ʹ���������ΪĿ���� S ��������ӷ��ŵķ�������

ʾ�� 1:

����: nums: [1, 1, 1, 1, 1], S: 3
���: 5
����: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

һ����5�ַ���������Ŀ���Ϊ3��
ע��:

����ǿգ��ҳ��Ȳ��ᳬ��20��
��ʼ������ĺͲ��ᳬ��1000��
��֤���ص����ս���ܱ�32λ�������¡�

*/
class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        find(nums,0,S);
        return count;
    }
    public void find(int[] nums,int index,int S){
        if(index == nums.length && S == 0) count++;
        else if(index < nums.length){
            find(nums,index+1,S-nums[index]);
            find(nums,index+1,S+nums[index]);
        }
        else return;
    }
}