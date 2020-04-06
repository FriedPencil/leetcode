/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

?

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
?

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

*/
class Solution {
    char[][] board = new char[1][1];
    char[][] visited = new char[200][200];
    String word = "";
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        char start = word.charAt(0);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == start){
                    if(word.length() == 1) return true;
                    visited[i][j] = 1;
                    search(1,i,j);
                    visited[i][j] = 0;
                }
            }
        }
        return flag;
    }
    public void search(int index, int x,int y){
        for(int i=0;i<4;i++){
            if(flag == true) return; //用全局变量的话，找到就立刻退出，不然会继续搜索导致超时
            int newx = x + dx[i];
            int newy = y + dy[i];
            if(newx >=0 && newx < board.length && newy >=0 && newy < board[0].length && visited[newx][newy]==0){
                visited[newx][newy] = 1;
                if(board[newx][newy] == word.charAt(index)){
                    if(index == word.length()-1) flag = true;
                    else search(index+1,newx,newy);
                }
                visited[newx][newy] = 0;
            }
        }
    }
}