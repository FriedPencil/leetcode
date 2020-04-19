/*
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1: 
输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0
示例 2: 
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1
注意:

给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。

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