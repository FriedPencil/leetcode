/*
��дһ���㷨���ж�һ�����ǲ��ǡ�����������

һ����������������Ϊ������һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���ͣ�Ȼ���ظ��������ֱ���������Ϊ 1��Ҳ����������ѭ����ʼ�ձ䲻�� 1��������Ա�Ϊ 1����ô��������ǿ�������

ʾ��: 

����: 19
���: true
����: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int res;
        while(true){
            res = 0;
            while(n>0){
                res += Math.pow(n%10,2);
                n /= 10;
            }
            n = res;
            if (res == 1) return true;
            boolean flag = hs.add(res);
            if(flag == false) return false;
        }
    }
}