/*
����һ������ nums����һ����СΪ?k?�Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k?�����֡���������ÿ��ֻ�����ƶ�һλ��

���ػ��������е����ֵ��

?

���ף�

����������ʱ�临�Ӷ��ڽ��������

?

ʾ��:

����: nums = [1,3,-1,-3,5,3,6,7], �� k = 3
���: [3,3,5,5,6,7] 
����: 

  �������ڵ�λ��                ���ֵ
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
?

��ʾ��

1 <= nums.length <= 10^5
-10^4?<= nums[i]?<= 10^4
1 <= k?<= nums.length

*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i] ) queue.pollLast();
            queue.offerLast(i);
            if(queue.peekFirst() <= i-k) queue.pollFirst();
            if(i >= k-1) list.add(queue.peekFirst());
        }
        int[] result = new int[list.size()];
        for(int i=0;i<result.length;i++) result[i] = nums[list.get(i)];
        return result;
    }
}