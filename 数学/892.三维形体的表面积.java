/*
��?N?*?N?�������ϣ����Ƿ���һЩ?1 * 1 * 1??�������塣

ÿ��ֵ?v = grid[i][j]?��ʾ?v?������������ڶ�Ӧ��Ԫ��?(i, j)?�ϡ�

���㷵����������ı������

?

ʾ�� 1��

���룺[[2]]
�����10
ʾ�� 2��

���룺[[1,2],[3,4]]
�����34
ʾ�� 3��

���룺[[1,0],[0,2]]
�����16
ʾ�� 4��

���룺[[1,1,1],[1,0,1],[1,1,1]]
�����32
ʾ��?5��

���룺[[2,2,2],[2,1,2],[2,2,2]]
�����46
?

��ʾ��

1 <= N <= 50
0 <= grid[i][j] <= 50

*/
class Solution {
    public int surfaceArea(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int surface = 0;
        int cover = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                surface += grid[i][j];
                cover += grid[i][j] > 1 ? grid[i][j]-1:0;
                if(i > 0) cover += Math.min(grid[i-1][j],grid[i][j]);
                if(j > 0) cover += Math.min(grid[i][j-1],grid[i][j]);
            }
        }
        return surface * 6 - cover * 2;
    }
}