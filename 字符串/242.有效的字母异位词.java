/*
���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�

ʾ�� 1:

����: s = "anagram", t = "nagaram"
���: true
ʾ�� 2:

����: s = "rat", t = "car"
���: false
˵��:
����Լ����ַ���ֻ����Сд��ĸ��
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] as=s.toCharArray();
        char[] ts=t.toCharArray();
        Arrays.sort(as);
        Arrays.sort(ts);
        return Arrays.equals(as,ts);
    }
}