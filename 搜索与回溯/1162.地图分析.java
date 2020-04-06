/*
你现在手里有一份大小为?N x N 的『地图』（网格）?grid，上面的每个『区域』（单元格）都用?0?和?1?标记好了。其中?0?代表海洋，1?代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。

我们这里说的距离是『曼哈顿距离』（?Manhattan Distance）：(x0, y0) 和?(x1, y1)?这两个区域之间的距离是?|x0 - x1| + |y0 - y1|?。

如果我们的地图上只有陆地或者海洋，请返回?-1。

?

示例 1：



输入：[[1,0,1],[0,0,0],[1,0,1]]
输出：2
解释： 
海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
示例 2：



输入：[[1,0,0],[0,0,0],[0,0,0]]
输出：4
解释： 
海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
?

提示：

1 <= grid.length == grid[0].length?<= 100
grid[i][j]?不是?0?就是?1

解：广搜，从每个陆地同时搜周边海洋，最后搜到的那个海洋即为结果（是最远的海洋，同时其值是距离最近陆地的距离）。
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