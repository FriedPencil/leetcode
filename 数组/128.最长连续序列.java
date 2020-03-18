/*

����һ��δ������������飬�ҳ���������еĳ��ȡ�

Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)��

ʾ��:

����: [100, 4, 200, 1, 3, 2]
���: 4
����: ����������� [1, 2, 3, 4]�����ĳ���Ϊ 4��

*/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(int n : nums) set.add(n);
        for(int n : nums){
            if(!set.contains(n-1)){
                int count = 1;
                int num = n;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                result = Math.max(result,count);
            }
        }
        return result;
    }
}