/*
����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 ������  "one 1"  ("һ��һ") , �� 11��
11 ������ "two 1s" ("����һ"��, �� 21��
21 ������ "one 2",  "one 1" ��"һ����" ,  "һ��һ") , �� 1211��

����һ�������� n��1 �� n �� 30��������������еĵ� n �

ע�⣺����˳�򽫱�ʾΪһ���ַ�����

 

ʾ�� 1:

����: 1
���: "1"
ʾ�� 2:

����: 4
���: "1211"
*/
class Solution {
    public String countAndSay(int n) {
                if(n==1) return "1";
        String str = countAndSay(n-1);
        String result = "";
        int num = 0;
        char character = str.charAt(0);
        for(int i=0;i<str.length();i++){

            if(character == str.charAt(i)) num++;
            else {
                result = result + num + character;
                character = str.charAt(i);
                num = 1;
            }
            if(i == str.length()-1) result = result + num + character;
        }
        return result;
    }
}
