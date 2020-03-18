/*
����һ��Excel����е������ƣ���������Ӧ������š�

���磬

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
ʾ�� 1:

����: "A"
���: 1
ʾ�� 2:

����: "AB"
���: 28
ʾ�� 3:

����: "ZY"
���: 701
*/
class Solution {
    public int titleToNumber(String s) {
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            res += Math.pow(26,s.length()-1-i) * (s.charAt(i)-64);
        }
        return res;
    }
}