/*
дһ����������� 1 �� n ���ֵ��ַ�����ʾ��

1. ���?n?��3�ı����������Fizz����

2. ���?n?��5�ı����������Buzz����

3.���?n?ͬʱ��3��5�ı�������� ��FizzBuzz����

ʾ����

n = 15,

����:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

*/
import java.util.*;
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            String result = "";
            if(i % 3 == 0) result += "Fizz";
            if(i % 5 == 0) result += "Buzz";
            if(result.equals("")) result += i;
            list.add(result);
        }
        return list;
    }
}