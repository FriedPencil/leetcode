/*
�������ְ������������ַ�: I�� V�� X�� L��C��D �� M��

�ַ�          ��ֵ
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��

ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������

I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90�� 
C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�

ʾ�� 1:

����: "III"
���: 3
ʾ�� 2:

����: "IV"
���: 4
ʾ�� 3:

����: "IX"
���: 9
ʾ�� 4:

����: "LVIII"
���: 58
����: L = 50, V= 5, III = 3.
ʾ�� 5:

����: "MCMXCIV"
���: 1994
����: M = 1000, CM = 900, XC = 90, IV = 4.
*/
class Solution {
    public int romanToInt(String s) {
        int num = 0;
        String s1 = s+'0';
        for (int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case 'I':
                    if (s1.charAt(i+1) == 'V'){
                        num += 4;
                        i++;
                    }
                    else if(s1.charAt(i+1) == 'X'){
                        num += 9;
                        i++;
                    }
                    else num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if (s1.charAt(i+1) == 'L'){
                        num += 40;
                        i++;
                    }
                    else if(s1.charAt(i+1) == 'C'){
                        num+=90;
                        i++;
                    }
                    else num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if (s1.charAt(i+1) == 'D'){
                        num += 400;
                        i++;
                    }
                    else if (s1.charAt(i+1) == 'M'){
                        num += 900;
                        i++;
                    }
                    else num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
        }
        return num;
    }
}