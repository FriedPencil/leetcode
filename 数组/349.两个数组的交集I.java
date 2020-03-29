/*
�����������飬��дһ���������������ǵĽ�����

ʾ�� 1:

����: nums1 = [1,2,2,1], nums2 = [2,2]
���: [2]
ʾ�� 2:

����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
���: [9,4]
˵��:

�������е�ÿ��Ԫ��һ����Ψһ�ġ�
���ǿ��Բ�������������˳��

*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums1) set.add(i);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:nums2){
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}