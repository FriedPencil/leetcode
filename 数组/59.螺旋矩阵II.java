/*
给定一个正整数?n，生成一个包含 1 到?n2?所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int row = 0,col = 0;
        int up = 0, left = 0, down = n-1, right = n-1;
        while(num <= n*n){
            while(col <= right && num <= n*n) { //注意终止
                matrix[row][col] = num++;
                col++;
            }
            if(num > n*n) break; //注意终止
            col--;up++;num--;
            while(row <= down && num <= n*n){
                matrix[row][col] = num++;
                row++;
            }
            if(num > n*n) break;
            row--;right--;num--;
            while(col >= left && num <= n*n) {
                matrix[row][col] = num++;
                col--;
            }
            if(num > n*n) break;
            col++;down--;num--;
            while(row >= up && num <= n*n) {
                matrix[row][col] = num++;
                row--;
            }
            if(num > n*n) break;
            row++;left++;num--;
        }
        return matrix;
    }
}