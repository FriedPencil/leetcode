/*
一条包含字母?A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释:?它可以解码为 "AB"（1 2）或者 "L"（12）。
示例?2:

输入: "226"
输出: 3
解释:?它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

*/
class Solution {
    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        int[] dp = new int[str.length+1];
        dp[0] = 1;
        if(str[0] == '0') return 0;
        dp[1] = 1;
        for(int i=2;i<=str.length;i++){
            if(str[i-1] == '0'){ //x0的情况
                if(str[i-2] == '1' || str[i-2] == '2') dp[i] = dp[i-2]; //10,20直接翻
                else return 0; // 00,30，40等等无法翻译
            }else{
                if((str[i-2] == '2' && str[i-1] > '6') || str[i-2] > '2' || str[i-2] == '0') dp[i] = dp[i-1]; //0x,以及超过26时，只能翻译一位
                else dp[i] = dp[i-1] + dp[i-2]; //其他情况翻译一位或两位
            }
        }
        return dp[str.length];
    }
}