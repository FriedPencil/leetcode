/*
����һ���� 0 �� 1 ��ɵľ����ҳ�ÿ��Ԫ�ص������ 0 �ľ��롣

��������Ԫ�ؼ�ľ���Ϊ 1 ��

ʾ�� 1: 
����:

0 0 0
0 1 0
0 0 0
���:

0 0 0
0 1 0
0 0 0
ʾ�� 2: 
����:

0 0 0
0 1 0
1 1 1
���:

0 0 0
0 1 0
1 2 1
ע��:

���������Ԫ�ظ��������� 10000��
����������������һ��Ԫ���� 0��
�����е�Ԫ��ֻ���ĸ�����������: �ϡ��¡����ҡ�

*/
import java.util.*;
class Solution {
    class Position{
        int x;
        int y;
        int dis;
        Position(int i,int j,int k){
            x = i;
            y = j;
            dis = k;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] != 0){
                    matrix[i][j] = bfs(matrix,i,j);
                }
            }
        }
        return matrix;
    }
    public int bfs(int[][] matrix, int x,int y){
        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x,y,0));
        while(!queue.isEmpty()){
            Position p = queue.poll();
            if(matrix[p.x][p.y] == 0) return p.dis;
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >=0 && nx < matrix.length && ny >=0 && ny < matrix[0].length){
                    queue.offer(new Position(nx,ny,p.dis+1));
                }
            }
        }
        return 0;
    }
}