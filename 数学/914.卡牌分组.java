/*
给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

每组都有?X?张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回?true。

?

示例 1：

输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
示例 2：

输入：[1,1,1,2,2,2,3,3]
输出：false
解释：没有满足要求的分组。
示例 3：

输入：[1]
输出：false
解释：没有满足要求的分组。
示例 4：

输入：[1,1]
输出：true
解释：可行的分组是 [1,1]
示例 5：

输入：[1,1,2,2,2,2]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[2,2]

提示：

1 <= deck.length <= 10000
0 <= deck[i] <?10000

*/
//统计每个数字的计数，计数的最大公约数即为分组需要的X，辗转相除法需要记住。
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for(int i:deck) count[i]++;
        int g = count[deck[0]];
        for(int i:count){
            if(i != 0){
               g = gcd(i,g);
            }
        }
        return g >= 2;
    
    }
    public int gcd(int x,int y){
        int remain = x % y;
        if(remain == 0) return y;
        else return gcd(y,remain);
    }
}