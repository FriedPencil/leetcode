/*
һ��������ĸ?A-Z ����Ϣͨ�����·�ʽ�����˱��룺

'A' -> 1
'B' -> 2
...
'Z' -> 26
����һ��ֻ�������ֵķǿ��ַ������������뷽����������

ʾ�� 1:

����: "12"
���: 2
����:?�����Խ���Ϊ "AB"��1 2������ "L"��12����
ʾ��?2:

����: "226"
���: 3
����:?�����Խ���Ϊ "BZ" (2 26), "VF" (22 6), ���� "BBF" (2 2 6) ��

*/
class Solution {
    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        int[] dp = new int[str.length+1];
        dp[0] = 1;
        if(str[0] == '0') return 0;
        dp[1] = 1;
        for(int i=2;i<=str.length;i++){
            if(str[i-1] == '0'){ //x0�����
                if(str[i-2] == '1' || str[i-2] == '2') dp[i] = dp[i-2]; //10,20ֱ�ӷ�
                else return 0; // 00,30��40�ȵ��޷�����
            }else{
                if((str[i-2] == '2' && str[i-1] > '6') || str[i-2] > '2' || str[i-2] == '0') dp[i] = dp[i-1]; //0x,�Լ�����26ʱ��ֻ�ܷ���һλ
                else dp[i] = dp[i-1] + dp[i-2]; //�����������һλ����λ
            }
        }
        return dp[str.length];
    }
}