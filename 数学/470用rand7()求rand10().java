/*
已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。

不要使用系统的 Math.random() 方法。

 

示例 1:

输入: 1
输出: [7]
示例 2:

输入: 2
输出: [8,4]
示例 3:

输入: 3
输出: [8,1,10]
*/
class Solution extends SolBase {
    public int rand10() {
        int a = 7,b = 7;
        do{
             a = rand7();
        }while(a == 7);
        if(a <= 3) a = 0;
        else a = 5;
        do{
             b = rand7();
        }while(b >= 6);
        return a+b;
    }
}