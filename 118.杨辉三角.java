/*
����һ���Ǹ����� numRows������������ǵ�ǰ numRows �С�



����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�

ʾ��:

����: 5
���:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(numRows == 0) return lists;
        list.add(1);
        lists.add(list);
        for(int i=1;i<numRows;i++){
            list = new ArrayList<>();
            list.add(1);
            List<Integer> l = lists.get(i-1);
            for(int j=0;j<l.size()-1;j++){
                list.add(l.get(j)+l.get(j+1));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}