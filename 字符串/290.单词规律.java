/*
����һ�ֹ��� pattern ��һ���ַ��� str ���ж� str �Ƿ���ѭ��ͬ�Ĺ��ɡ�

����� ��ѭ ָ��ȫƥ�䣬���磬 pattern ���ÿ����ĸ���ַ��� str �е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧ���ɡ�

ʾ��1:

����: pattern = "abba", str = "dog cat cat dog"
���: true
ʾ�� 2:

����:pattern = "abba", str = "dog cat cat fish"
���: false
ʾ�� 3:

����: pattern = "aaaa", str = "dog cat cat dog"
���: false
ʾ�� 4:

����: pattern = "abba", str = "dog dog dog dog"
���: false
˵��:
����Լ��� pattern ֻ����Сд��ĸ�� str �������ɵ����ո�ָ���Сд��ĸ��  
*/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map hm1 = new HashMap<>();
        Map hm2 = new HashMap<>();

        String[] s = str.split(" ");
        if(pattern.length() != s.length) return false;
        for(int i=0;i<s.length;i++){
            if (!hm1.containsKey(pattern.charAt(i))){
                hm1.put(pattern.charAt(i),s[i]);
            }
            else{
                if(!hm1.get(pattern.charAt(i)).equals(s[i])) return false; 
                //hm.get()���ص���object��������==�Ƚ�
            }
            if (!hm2.containsKey(s[i])){
                hm2.put(s[i],pattern.charAt(i));
            }
            else{
                if(!hm2.get(s[i]).equals(pattern.charAt(i))) return false;
            }
        }
        return true;
    }
}