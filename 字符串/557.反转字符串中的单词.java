/*
����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��

ʾ��?1:

����: "Let's take LeetCode contest"
���: "s'teL ekat edoCteeL tsetnoc"?
ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�

*/
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.trim().toCharArray();
        int i=0,j=0;
        while(j < arr.length){
            while(j < arr.length && arr[j] != ' ') j++;
            reverse(arr,i,j-1);
            while(j < arr.length && arr[j] == ' ') j++;
            i = j;
        }
        String result = "";
        for(char c : arr) result += c;
        return result;
    }
    public void reverse(char[] arr, int s, int e){
        while(s < e){
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}