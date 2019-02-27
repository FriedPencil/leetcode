/*
����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��

���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�

����Լ���������� 0 ֮�⣬��������������㿪ͷ��

ʾ�� 1:

����: [1,2,3]
���: [1,2,4]
����: ���������ʾ���� 123��
ʾ�� 2:

����: [4,3,2,1]
���: [4,3,2,2]
����: ���������ʾ���� 4321��
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        int value;
        do{
            value = digits[index];
            value++;
            digits[index] = value;
            if ( value == 10 ){
                digits[index] = 0;
                value = 0;
                index--;
            }
        }while(index >= 0 && value == 0);
        if(index < 0){
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            for(int i=1;i<newDigits.length;i++){
                newDigits[i] = digits[i-1];
            }
            return newDigits;
        }
        return digits;
    }
}