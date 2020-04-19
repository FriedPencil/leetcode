/*
����һ��û���ظ�Ԫ�ص����顣

ʾ��:

// �����ּ��� 1, 2 �� 3 ��ʼ�����顣
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// �������� [1,2,3] �����ؽ�����κ� [1,2,3]�����з��صĸ���Ӧ����ͬ��
solution.shuffle();

// �������鵽���ĳ�ʼ״̬[1,2,3]��
solution.reset();

// �����������[1,2,3]���Һ�Ľ����
solution.shuffle();

*/
class Solution {
    int[] arr;
    int[] origin;
    public Solution(int[] nums) {
        origin = nums;
        arr = new int[nums.length];
        System.arraycopy(nums,0,arr,0,nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuArr = new int[arr.length];
        Random r = new Random();
        for(int i=0;i<arr.length;i++){
            int index = r.nextInt(arr.length-i)+i; //ע������ĳ��������������ķ���
            swap(arr,i,index);
            shuArr[i] = arr[i];
        }
        return shuArr;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */