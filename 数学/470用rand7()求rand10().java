/*
���з��� rand7 ������ 1 �� 7 ��Χ�ڵľ��������������дһ������ rand10 ���� 1 �� 10 ��Χ�ڵľ������������

��Ҫʹ��ϵͳ�� Math.random() ������

 

ʾ�� 1:

����: 1
���: [7]
ʾ�� 2:

����: 2
���: [8,4]
ʾ�� 3:

����: 3
���: [8,1,10]
*/
class Solution extends SolBase {
    public int rand10() {
        int a = 7,b = 7;
        do{
             a = rand7();
        }while(a == 7);
        if(a <= 3) a = 0;
        else a = 5;
        do{
             b = rand7();
        }while(b >= 6);
        return a+b;
    }
}