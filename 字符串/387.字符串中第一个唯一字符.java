/*
����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��

����:

s = "leetcode"
���� 0.

s = "loveleetcode",
���� 2.
*/
class Solution {
    public int firstUniqChar(String s) {
        int[] hash = new int[256];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)]==1) return i;
        }
        return -1;
    }
}