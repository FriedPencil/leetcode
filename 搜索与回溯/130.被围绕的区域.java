/*
给定一个二维的矩阵，包含?'X'?和?'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的?'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的?'O'?都不会被填充为?'X'。 任何不在边界上，或不与边界上的?'O'?相连的?'O'?最终都会被填充为?'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

解：从边界搜索O，把O全部变为Y，那么搜不到的O就可以变为X，最后把Y变回O。
*/
class Solution {
    boolean[][] visited;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            if(board[i][0] == 'O') search(board,i,0);
            if(board[i][board[0].length-1] == 'O') search(board,i,board[0].length-1);
        }
       for(int i=0;i<board[0].length;i++){
            if(board[0][i] == 'O') search(board,0,i);
            if(board[board.length-1][i] == 'O') search(board,board.length-1,i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
    public void search(char[][] board,int x,int y){
        if(x >=0 && x<board.length && y >=0 && y<board[0].length && !visited[x][y]){
            if(board[x][y] == 'O'){
                visited[x][y] = true;
                board[x][y] = 'Y';
                for(int i=0;i<4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    search(board,nx,ny);
                }
            }
        }
    }
}