/*
����һ���Ǹ����� k������ k �� 33������������ǵĵ� k �С�



����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�

ʾ��:

����: 3
���: [1,3,3,1]
���ף�

������Ż�����㷨�� O(k) �ռ临�Ӷ���
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0) return list;
        for(int i=1;i<=rowIndex;i++){
            long Cni_1 = list.get(i-1);
            int Cn_i = (int) ( Cni_1 * (rowIndex-i+1) / i);
            list.add(Cn_i);
        }
        return list;
    }
}