/*
����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�

���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�

?

ʾ��:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

���� word = "ABCCED", ���� true
���� word = "SEE", ���� true
���� word = "ABCB", ���� false
?

��ʾ��

board �� word ��ֻ������д��СдӢ����ĸ��
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
            if(flag == true) return; //��ȫ�ֱ����Ļ����ҵ��������˳�����Ȼ������������³�ʱ
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