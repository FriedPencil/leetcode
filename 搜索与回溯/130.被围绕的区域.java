/*
����һ����ά�ľ��󣬰���?'X'?��?'O'����ĸ O����

�ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е�?'O' �� 'X' ��䡣

ʾ��:

X X X X
X O O X
X X O X
X O X X
������ĺ����󣬾����Ϊ��

X X X X
X X X X
X X X X
X O X X
����:

��Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ�?'O'?�����ᱻ���Ϊ?'X'�� �κβ��ڱ߽��ϣ�����߽��ϵ�?'O'?������?'O'?���ն��ᱻ���Ϊ?'X'���������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�

�⣺�ӱ߽�����O����Oȫ����ΪY����ô�Ѳ�����O�Ϳ��Ա�ΪX������Y���O��
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