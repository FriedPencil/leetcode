/*
����һ���ǿյ��������飬�������г���Ƶ��ǰ?k?�ߵ�Ԫ�ء�

ʾ�� 1:

����: nums = [1,1,1,2,2,3], k = 2
���: [1,2]
ʾ�� 2:

����: nums = [1], k = 1
���: [1]
˵����

����Լ��������?k?���Ǻ���ģ��� 1 �� k �� �����в���ͬ��Ԫ�صĸ�����
����㷨��ʱ�临�Ӷȱ������� O(n log n) ,?n?������Ĵ�С��

*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
         HashMap<Integer,Integer> map = new HashMap<>();
         for(int i=0;i<nums.length;i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
         PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{return map.get(o1)-map.get(o2);});
         for(int i:map.keySet()){
             queue.offer(i);
             if(queue.size() > k) queue.poll();
         }
         LinkedList<Integer> list = new LinkedList<>();
         while(queue.size() > 0){
             list.addFirst(queue.poll());
         }
         return list;
    }
}