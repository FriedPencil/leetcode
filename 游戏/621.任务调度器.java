/*
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为?n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。

?

示例 ：

输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.


解：按任务数量从高到低排序，每轮依次从高到低取一个任务，每轮取n+1次，如果无任务可取（并非取完了）也要计时，每取一轮，重新排序。直到所有任务取完。
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] task = new int[26];
        for(int i=0;i<tasks.length;i++) task[tasks[i]-'A']++;
        Arrays.sort(task);
        int time = 0;
        while(task[25] > 0){
            for(int i=0;i<=n;i++){
                if(task[25] == 0) break;
                if(i<26 && task[25-i] > 0) task[25-i]--;
                time++;
            }
            Arrays.sort(task);
        }
        return time;
    }
}