/*
���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0)���ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��

˵�����㲻����б��������?n?��ֵ����Ϊ 2��

?



ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ?49��

?

ʾ����

���룺[1,8,6,2,5,4,8,3,7]
�����49

*/
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = area(height,left,right);
        while(left < right){
            if(height[left] < height[right]){
                left++;
                int a = area(height,left,right);
                if(a > max) max = a;
            }else{
                right--;
                int b = area(height,left,right);
                if(b > max) max = b;
            }
        }
        return max;
    }
    public int area(int[] height,int left, int right){
        return Math.min(height[left],height[right]) * (right-left);
    }
}