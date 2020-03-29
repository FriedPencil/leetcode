/*
������������һ�ݴ�СΪ?N x N �ġ���ͼ��������?grid�������ÿ�������򡻣���Ԫ�񣩶���?0?��?1?��Ǻ��ˡ�����?0?������1?����½�أ���֪������½��������Զ�ĺ�������������һ�����뷵�ظú����������������½������ľ��롣

��������˵�ľ����ǡ������پ��롻��?Manhattan Distance����(x0, y0) ��?(x1, y1)?����������֮��ľ�����?|x0 - x1| + |y0 - y1|?��

������ǵĵ�ͼ��ֻ��½�ػ��ߺ����뷵��?-1��

?

ʾ�� 1��



���룺[[1,0,1],[0,0,0],[1,0,1]]
�����2
���ͣ� 
�������� (1, 1) ������½������֮��ľ��붼�ﵽ���������Ϊ 2��
ʾ�� 2��



���룺[[1,0,0],[0,0,0],[0,0,0]]
�����4
���ͣ� 
�������� (2, 2) ������½������֮��ľ��붼�ﵽ���������Ϊ 4��
?

��ʾ��

1 <= grid.length == grid[0].length?<= 100
grid[i][j]?����?0?����?1

�⣺���ѣ���ÿ��½��ͬʱ���ܱߺ�������ѵ����Ǹ�����Ϊ���������Զ�ĺ���ͬʱ��ֵ�Ǿ������½�صľ��룩��
*/
import java.util.*;
class Solution {
    class Position{
        int x;
        int y;
        Position(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int maxDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return -1;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Position> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) queue.offer(new Position(i,j));
            }
        }
        Position p = null;
        while(!queue.isEmpty()){
            p = queue.poll();
            for(int i=0;i<4;i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(x >= 0 && x < grid.length && y >=0 && y < grid[0].length){
                    if(grid[x][y] == 0 && visited[x][y] == 0) {
                        queue.offer(new Position(x,y));  
                        visited[x][y] = visited[p.x][p.y]+1;
                    }    
                }
            }
        }
        if(p == null || visited[p.x][p.y] == 0) return -1;
        else return visited[p.x][p.y];
    } 
}