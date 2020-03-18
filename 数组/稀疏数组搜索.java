/*
稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。

示例1:

 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 输出：-1
 说明: 不存在返回-1。
示例2:

 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 输出：4

*/
class Solution {
    public int findString(String[] words, String s) {
        int start=0,end = words.length-1;
        while(start <= end){ //这里的等于号一定要
            while(words[start].equals("")) start++;
            while(words[end].equals("")) end--;
            int mid = (start+end)/2;
            while(words[mid].equals("")){
                mid++;
                if(words[mid].equals(words[end])) end = (start+end)/2;
            }

            if(words[mid].equals(s)) return mid;
            else if(words[mid].compareTo(s) <0) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}