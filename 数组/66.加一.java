/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
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