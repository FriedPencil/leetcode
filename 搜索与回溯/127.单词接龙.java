/*
给定两个单词（beginWord?和 endWord）和一个字典，找到从?beginWord  到?endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例?1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出:?0

解释:?endWord "cog" 不在字典中，所以无法进行转换。


解：把列表中的每个单词都生成若干的转换序列，如dog生成三个映射序列， *og  d*g  do* 映射到三个序列。
然后对起始单词开始加入队列进行广搜，这个单词把每个位置取*，找到映射序列，在里边遍历是否有目标词，如果没有就把序列里的词再加入队列。 
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