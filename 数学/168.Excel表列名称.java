/*
����һ������������������ Excel �������Ӧ�������ơ�

���磬

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
ʾ�� 1:

����: 1
���: "A"
ʾ�� 2:

����: 28
���: "AB"
ʾ�� 3:

����: 701
���: "ZY"
*/
class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        int rem;
        while(n > 0){
            n--;
            rem=n%26;
            char c = (char)(rem+65);
            sb.append(c);
            n/=26;

        }
        String s =sb.reverse().toString();
        return s;
    }
}