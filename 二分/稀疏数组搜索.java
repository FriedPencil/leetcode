/*
ϡ�������������и��ź�����ַ������飬����ɢ����һЩ���ַ�������дһ�ַ������ҳ������ַ�����λ�á�

ʾ��1:

 ����: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 �����-1
 ˵��: �����ڷ���-1��
ʾ��2:

 ���룺words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 �����4

*/
class Solution {
    public int findString(String[] words, String s) {
        int start=0,end = words.length-1;
        while(start <= end){ //����ĵ��ں�һ��Ҫ
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