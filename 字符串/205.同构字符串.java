/*
���������ַ��� s �� t���ж������Ƿ���ͬ���ġ�

��� s �е��ַ����Ա��滻�õ� t ����ô�������ַ�����ͬ���ġ�

���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����

ʾ�� 1:

����: s = "egg", t = "add"
���: true
ʾ�� 2:

����: s = "foo", t = "bar"
���: false
ʾ�� 3:

����: s = "paper", t = "title"
���: true
˵��:
����Լ��� s �� t ������ͬ�ĳ��ȡ�
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap hm = new HashMap();
        Object flag = null;
        for(int i=0;i<s.length();i++){
            flag = hm.put(s.charAt(i),t.charAt(i));
            if( flag != null && !flag.equals(t.charAt(i)))  return false;
        }
        hm.clear();
        flag = null;
        for(int i=0;i<s.length();i++){
            flag = hm.put(t.charAt(i),s.charAt(i));
            if( flag != null && !flag.equals(s.charAt(i)))  return false;
        }
        return true;
    }
}