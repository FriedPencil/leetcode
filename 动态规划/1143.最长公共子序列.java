/*
���������ַ��� text1 �� text2�������������ַ���������������С�

һ���ַ����� ������ ��ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С������ַ����ġ����������С����������ַ�������ͬӵ�е������С�

���������ַ���û�й��������У��򷵻� 0��

 

ʾ�� 1:

���룺text1 = "abcde", text2 = "ace" 
�����3  
���ͣ�������������� "ace"�����ĳ���Ϊ 3��
ʾ�� 2:

���룺text1 = "abc", text2 = "abc"
�����3
���ͣ�������������� "abc"�����ĳ���Ϊ 3��
ʾ�� 3:

���룺text1 = "abc", text2 = "def"
�����0
���ͣ������ַ���û�й��������У����� 0��
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); 
            }
        }
        return dp[length1][length2];
    }
}