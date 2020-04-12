/*
����һ��������?n������һ������ 1 ��?n2?����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���

ʾ��:

����: 3
���:
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
            while(col <= right && num <= n*n) { //ע����ֹ
                matrix[row][col] = num++;
                col++;
            }
            if(num > n*n) break; //ע����ֹ
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