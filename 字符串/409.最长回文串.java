/*
����һ��������д��ĸ��Сд��ĸ���ַ������ҵ�ͨ����Щ��ĸ����ɵ���Ļ��Ĵ���

�ڹ�������У���ע�����ִ�Сд������ "Aa" ���ܵ���һ�������ַ�����

ע��:
�����ַ����ĳ��Ȳ��ᳬ�� 1010��

ʾ�� 1:

����:
"abccccdd"

���:
7

����:
���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
*/
//ͳ����ĸ�����������ż��������������������ֻ������һ����ʣ�µ�����ͳͳ��Ϊ���һ��������
class Solution {
    public int longestPalindrome(String s) {
        int[] letter = new int[256];
        for(int i=0;i<s.length();i++){
            letter[s.charAt(i)]++;
        }
        int ans = 0;
        for(int i=0;i<256;i++){
            if(letter[i] != 0){
                ans += letter[i]/2 * 2;
                if((letter[i] & 1) == 1 && (ans & 1) == 0) ans++; 
            }
        }
        return ans;
    }
}