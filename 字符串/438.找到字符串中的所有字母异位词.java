/*
����һ���ַ���?s?��һ���ǿ��ַ���?p���ҵ�?s?��������?p?����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������

�ַ���ֻ����СдӢ����ĸ�������ַ���?s?�� p?�ĳ��ȶ������� 20100��

˵����

��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
�����Ǵ������˳��
ʾ��?1:

����:
s: "cbaebabacd" p: "abc"

���:
[0, 6]

����:
��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����ĸ��λ�ʡ�
��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����ĸ��λ�ʡ�
?ʾ�� 2:

����:
s: "abab" p: "ab"

���:
[0, 1, 2]

����:
��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����ĸ��λ�ʡ�
��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�

*/
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[26];
        for(int i=0;i<p.length();i++) hash[p.charAt(i)-'a']++;
        int i=0,j=p.length()-1;
        while(j<s.length()){
            int[] temp = Arrays.copyOf(hash,26);     
            for(int k=i;k<=j;k++){
                char c = s.charAt(k);
                if(temp[c-'a'] == 0) break;
                else{
                    temp[c-'a']--;
                    if(k == j) list.add(i);
                }
            }
            i++;
            j++;
        }
        return list;
    }
}

/*
���Ż����㷨700ms->14ms
*/
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[26];
        for(int i=0;i<p.length();i++) hash[p.charAt(i)-'a']++;
        int i=0,j=0;
        while(i < s.length() && j < s.length()){
            char c = s.charAt(j);
            if(hash[c-'a'] == 0){
                if(i == j){ //�����ж��Ǹ��������ڵ��ַ����Ǵ��ڵ����������ϣ��˴�Ϊ����������
                    i++;
                    j++;
                }else{ //�˴�Ϊ���ڵ��Ǹ���������
                    hash[s.charAt(i)-'a']++;
                    i++;  
                }
            }
            else{
                hash[c-'a']--;
                j++;
            }
            if(j-i == p.length()){
                list.add(i);
                hash[s.charAt(i)-'a']++;
                i++;
            } 
        }
        return list;
    }
}