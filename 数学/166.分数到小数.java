/*
给定两个整数，分别表示分数的分子?numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:

输入: numerator = 1, denominator = 2
输出: "0.5"
示例?2:

输入: numerator = 2, denominator = 1
输出: "2"
示例?3:

输入: numerator = 2, denominator = 3
输出: "0.(6)"

*/
import java.util.*;
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        long dividend = Math.abs((long)numerator); //注意使用abs前要先转为long，不然会按int计算溢出
        long divisor = Math.abs((long)denominator);
        StringBuilder result = new StringBuilder();
        if(numerator < 0 ^ denominator < 0){ //学习到布尔值可以异或
            result.append("-");
        }
        result.append(String.valueOf(dividend/divisor));
        long remainder = dividend % divisor;
        if(remainder == 0l) return result.toString();
        result.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        while(remainder != 0){
            if(map.containsKey(remainder)){
                result.insert(map.get(remainder),"("); //StringBuilder的insert方法
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