/*
���һ��֧����ƽ��?ʱ�临�Ӷ� O(1)?�£�ִ�����²��������ݽṹ��

insert(val)����Ԫ�� val ������ʱ���򼯺��в�����
remove(val)��Ԫ�� val ����ʱ���Ӽ������Ƴ����
getRandom������������м����е�һ�ÿ��Ԫ��Ӧ������ͬ�ĸ��ʱ����ء�
ʾ�� :

// ��ʼ��һ���յļ��ϡ�
RandomizedSet randomSet = new RandomizedSet();

// �򼯺��в��� 1 ������ true ��ʾ 1 ���ɹ��ز��롣
randomSet.insert(1);

// ���� false ����ʾ�����в����� 2 ��
randomSet.remove(2);

// �򼯺��в��� 2 ������ true ���������ڰ��� [1,2] ��
randomSet.insert(2);

// getRandom Ӧ������� 1 �� 2 ��
randomSet.getRandom();

// �Ӽ������Ƴ� 1 ������ true ���������ڰ��� [2] ��
randomSet.remove(1);

// 2 ���ڼ����У����Է��� false ��
randomSet.insert(2);

// ���� 2 �Ǽ�����Ψһ�����֣�getRandom ���Ƿ��� 2 ��
randomSet.getRandom();

*/
import java.util.*;
class RandomizedSet {
    HashMap<Integer,Integer> map; //�洢ֵ��������ӳ��
    ArrayList<Integer> list;//�洢ֵ
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        list.set(index,list.get(list.size()-1)); //ɾ��ʱ�����б����ֵ�滻��ɾ�����ֵ
        map.put(list.get(index),index); //�ǵ��޸�map�����ұ������б�remove֮ǰ�޸ģ��������ֻ��һ��Ԫ�ػᱨ��
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }
}