/*
给定一个?m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例?1:

输入: 
[
? [1,1,1],
? [1,0,1],
? [1,1,1]
]
输出: 
[
? [1,0,1],
? [0,0,0],
? [1,0,1]
]
示例?2:

输入: 
[
? [0,1,2,0],
? [3,4,5,2],
? [1,3,1,5]
]
输出: 
[
? [0,0,0,0],
? [0,4,5,0],
? [0,3,1,0]
]

*/
class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    for(int k=0;k<matrix.length;k++){
                        if(matrix[k][j] != 0) matrix[k][j] = -1000000;
                    }
                    for(int k=0;k<matrix[0].length;k++){
                        if(matrix[i][k] != 0) matrix[i][k] = -1000000;
                    }
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == -1000000) matrix[i][j] = 0;
            }
        }
    }
}