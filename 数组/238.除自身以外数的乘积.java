/*

����һ������Ϊ n ���������� nums������ n > 1������������� output ������ output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���


ʾ��:

����: [1,2,3,4]
���: [24,12,8,6]
 

��ʾ����Ŀ���ݱ�֤����֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺���������������飩�ĳ˻����� 32 λ������Χ�ڡ�

˵��: �벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣

���ף�
������ڳ����ռ临�Ӷ�����������Ŀ�𣿣� ���ڶԿռ临�Ӷȷ�����Ŀ�ģ�������鲻����Ϊ����ռ䡣��
        //.....
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            pre[i] = pre[i] * R;
            R *= nums[i];
        }
		return pre;

*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1] * nums[i-1];
        }
        int[] suc = new int[nums.length];
        suc[suc.length-1] = 1;
        for(int j=nums.length-2;j>=0;j--){
            suc[j] = suc[j+1] * nums[j+1];
        }
        int[] result = new int[nums.length];
        for(int i=0;i<result.length;i++){
            result[i] = pre[i] * suc[i];
        }
        return result;
    }
}