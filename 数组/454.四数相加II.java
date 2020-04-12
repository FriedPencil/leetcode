/*
�����ĸ����������������б�?A , B , C , D ,�����ж��ٸ�Ԫ�� (i, j, k, l)?��ʹ��?A[i] + B[j] + C[k] + D[l] = 0��

Ϊ��ʹ����򵥻������е� A, B, C, D ������ͬ�ĳ���?N���� 0 �� N �� 500 �����������ķ�Χ�� -228 �� 228 - 1 ֮�䣬���ս�����ᳬ��?231 - 1 ��

����:

����:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

���:
2

����:
����Ԫ������:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

*/
import java.util.HashMap;
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int ab = A[i] + B[j];
                map.put(ab,map.getOrDefault(ab,0)+1);
            }
        }
        int result = 0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int cd = -C[i] - D[j];
                result += map.getOrDefault(cd,0);
            }
        }
        return result;
    }
}