/*
�����������ʣ�beginWord?�� endWord����һ���ֵ䣬�ҵ���?beginWord  ��?endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���

ÿ��ת��ֻ�ܸı�һ����ĸ��
ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
˵��:

���������������ת�����У����� 0��
���е��ʾ�����ͬ�ĳ��ȡ�
���е���ֻ��Сд��ĸ��ɡ�
�ֵ��в������ظ��ĵ��ʡ�
����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
ʾ��?1:

����:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

���: 5

����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     �������ĳ��� 5��
ʾ�� 2:

����:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

���:?0

����:?endWord "cog" �����ֵ��У������޷�����ת����


�⣺���б��е�ÿ�����ʶ��������ɵ�ת�����У���dog��������ӳ�����У� *og  d*g  do* ӳ�䵽�������С�
Ȼ�����ʼ���ʿ�ʼ������н��й��ѣ�������ʰ�ÿ��λ��ȡ*���ҵ�ӳ�����У�����߱����Ƿ���Ŀ��ʣ����û�оͰ�������Ĵ��ټ�����С� 
*/
import java.util.*;
class Solution {
    class Trans{
        String word;
        int step;
        Trans(String i ,int j){
            word = i;
            step = j;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,List<String>> map = new HashMap<>();
        int L = beginWord.length();
        for(String s:wordList){
            for(int i=0;i<L;i++){
                String temp = s.substring(0,i) + "*" + s.substring(i+1,s.length());
                List<String> list = map.getOrDefault(temp,new ArrayList<>());
                list.add(s);
                map.put(temp,list);
            }
        }
        HashSet<String> visited = new HashSet<>();
        Queue<Trans> queue = new LinkedList<>();
        queue.offer(new Trans(beginWord,1));
        while(!queue.isEmpty()){
            Trans trans = queue.poll();
            String word = trans.word;
            int step = trans.step;
            visited.add(word);
            for(int i=0;i<L;i++){
                String temp = word.substring(0,i) + "*" + word.substring(i+1,word.length());
                if(!map.containsKey(temp)) continue;
                List<String> list = map.get(temp);
                for(String s:list){
                    if(s.equals(endWord)) return step+1;
                    if(!visited.contains(s)) queue.offer(new Trans(s,step+1));
                }
            }
        }
        return 0;
    }
}