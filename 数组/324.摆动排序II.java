/*
����һ�����������?nums�������������г�?nums[0] < nums[1] > nums[2] < nums[3]...?��˳��

ʾ��?1:

����: nums = [1, 5, 1, 1, 6, 4]
���: һ�����ܵĴ��� [1, 4, 1, 5, 1, 6]
ʾ�� 2:

����: nums = [1, 3, 2, 2, 3, 1]
���: һ�����ܵĴ��� [2, 3, 1, 3, 1, 2]
˵��:
����Լ����������붼��õ���Ч�Ľ����


�⣺�ÿ���ѡ���ҵ���λ����Ȼ�󰴺����췽���ų������֣����м��ѿ�����������Ȼ�����������롣
*/
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums.length <= 1) return; //ע��С�ڵ���1����Ȼ����ѡ���ʧ��
        int mid = find(nums,0,nums.length-1,nums.length/2); //ע����λ����ѡȡ��Ϊ����/2,�õ�����ֱֵ������λ��������
        int left=0,right=nums.length-1,p=0;
        while(p <= right){
            if(nums[p] > mid){
                swap(nums,p,right);
                right--;
            }else if(nums[p] < mid){
                swap(nums,p,left);
                left++;
                p++;
            }else p++;
        }
        int[] result = new int[nums.length];
        for(int i=0;i<result.length;i++){
            if((i & 1) == 0) result[i] = nums[(nums.length-1)/2-i/2];
            else result[i] = nums[nums.length-1-i/2];
        }
        System.arraycopy(result,0,nums,0,result.length);
    }
    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int partition(int[] nums,int low ,int high){
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] >= temp) high--;
            nums[low] = nums[high];
            while(low < high && nums[low] <= temp) low++;
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
    public int find(int[] nums,int low,int high,int k){
        int p = partition(nums,low,high);
        if(p == k) return nums[p];
        else if(p > k)  return find(nums,low,p-1, k);
        else return find(nums,p+1,high,k);
    }
}