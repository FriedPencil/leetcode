/*
����һ�������б����ǽ�����б�����һ�������ַ���?S?��һ�������б� A��

���磬�������б��� ["time", "me", "bell"]�����ǾͿ��Խ����ʾΪ S = "time#bell#" �� indexes = [0, 2, 5]��

����ÿһ�����������ǿ���ͨ�����ַ��� S?��������λ�ÿ�ʼ��ȡ�ַ�����ֱ�� "#" ���������ָ�����֮ǰ�ĵ����б�

��ô�ɹ��Ը��������б���б������С�ַ��������Ƕ����أ�

?

ʾ����

����: words = ["time", "me", "bell"]
���: 10
˵��: S = "time#bell#" �� indexes = [0, 2, 5] ��
?

��ʾ��

1 <= words.length?<= 2000
1 <=?words[i].length?<= 7
ÿ�����ʶ���Сд��ĸ ��

�⣺1.��ÿ�����ʣ�ö�����׺����set��ɾ�������ʣ�µĶ��ǲ���Ϊ�������ʺ�׺�ĵ��ʣ�ͳ�Ƴ��ȼ��ɡ�
2.�����ʹ���ֵ�����
*/

import java.util.HashSet;
class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>();
        for(String s:words) set.add(s);
        for(String s:words){
            for(int i=1;i<s.length();i++){
                String temp = s.substring(i,s.length());
                set.remove(temp);
            }
        }
        int count = 0;
        for(String s:set){
            count += (s.length()+1);
        }
        return count;
    }
}

