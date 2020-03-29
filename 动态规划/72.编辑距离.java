/*
������������?word1 ��?word2���������?word1?ת����?word2 ��ʹ�õ����ٲ�����?��

����Զ�һ�����ʽ����������ֲ�����

����һ���ַ�
ɾ��һ���ַ�
�滻һ���ַ�
ʾ��?1:

����: word1 = "horse", word2 = "ros"
���: 3
����: 
horse -> rorse (�� 'h' �滻Ϊ 'r')
rorse -> rose (ɾ�� 'r')
rose -> ros (ɾ�� 'e')
ʾ��?2:

����: word1 = "intention", word2 = "execution"
���: 5
����: 
intention -> inention (ɾ�� 't')
inention -> enention (�� 'i' �滻Ϊ 'e')
enention -> exention (�� 'n' �滻Ϊ 'x')
exention -> exection (�� 'n' �滻Ϊ 'c')
exection -> execution (���� 'u')

*/
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<=word1.length();i++) dp[i][0] = dp[i-1][0]+1;
        for(int i=1;i<=word2.length();i++) dp[0][i] = dp[0][i-1]+1;
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}