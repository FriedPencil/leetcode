/*
����һ��Ƕ�׵������б��������һ����������ʹ���ܹ�������������б��е�����������

�б��е�ÿһ�����Ϊһ����������������һ���б������б��Ԫ��Ҳ�������������������б�

 

ʾ�� 1:

����: [[1,1],2,[1,1]]
���: [1,1,2,1,1]
����: ͨ���ظ����� next ֱ�� hasNext ���� false��next ���ص�Ԫ�ص�˳��Ӧ����: [1,1,2,1,1]��
ʾ�� 2:

����: [1,[4,[6]]]
���: [1,4,6]
����: ͨ���ظ����� next ֱ�� hasNext ���� false��next ���ص�Ԫ�ص�˳��Ӧ����: [1,4,6]��
*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        fun(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
    public void fun(List<NestedInteger> nestedList){
        for(NestedInteger n : nestedList){
            if(n.isInteger()) list.add(n.getInteger());
            else fun(n.getList());
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */