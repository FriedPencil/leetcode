/*
����һ��?m x n �ľ������һ��Ԫ��Ϊ 0�����������к��е�����Ԫ�ض���Ϊ 0����ʹ��ԭ���㷨��

ʾ��?1:

����: 
[
? [1,1,1],
? [1,0,1],
? [1,1,1]
]
���: 
[
? [1,0,1],
? [0,0,0],
? [1,0,1]
]
ʾ��?2:

����: 
[
? [0,1,2,0],
? [3,4,5,2],
? [1,3,1,5]
]
���: 
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