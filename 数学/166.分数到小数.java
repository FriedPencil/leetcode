/*
���������������ֱ��ʾ�����ķ���?numerator �ͷ�ĸ denominator�����ַ�����ʽ����С����

���С������Ϊѭ��С������ѭ���Ĳ������������ڡ�

ʾ�� 1:

����: numerator = 1, denominator = 2
���: "0.5"
ʾ��?2:

����: numerator = 2, denominator = 1
���: "2"
ʾ��?3:

����: numerator = 2, denominator = 3
���: "0.(6)"

*/
import java.util.*;
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        long dividend = Math.abs((long)numerator); //ע��ʹ��absǰҪ��תΪlong����Ȼ�ᰴint�������
        long divisor = Math.abs((long)denominator);
        StringBuilder result = new StringBuilder();
        if(numerator < 0 ^ denominator < 0){ //ѧϰ������ֵ�������
            result.append("-");
        }
        result.append(String.valueOf(dividend/divisor));
        long remainder = dividend % divisor;
        if(remainder == 0l) return result.toString();
        result.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        while(remainder != 0){
            if(map.containsKey(remainder)){
                result.insert(map.get(remainder),"("); //StringBuilder��insert����
                result.append(")");
                break;
            }
            map.put(remainder,result.length());
            remainder *= 10;
            result.append(String.valueOf(remainder/divisor));
            remainder = remainder % divisor;
        }
        return result.toString();
    }
}