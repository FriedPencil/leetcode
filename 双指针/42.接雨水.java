/*
����?n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��



������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ����?��л Marcos ���״�ͼ��

ʾ��:

����: [0,1,0,2,1,0,1,3,2,1,2,1]
���: 6

*/
//�ؼ�����ÿ�������ˮ������������������ߵ�Ľ�Сֵ��ȥ��ǰ��߶ȡ��������ɽ�
//�˴���˫ָ��洢��
class Solution {
    public int trap(int[] height) {
        int left=0,right = height.length-1;
        int ans = 0;
        int maxLeft =0, maxRight = 0;
        while(left < right){
            if(height[left] < height[right]){ //ע���ǵ�߶Ȳ���max�߶�
                maxLeft = Math.max(maxLeft,height[left]);
                if(maxLeft - height[left] >0 ) ans += maxLeft - height[left];
                left++;
            }else{
                maxRight = Math.max(maxRight,height[right]);
                if(maxRight - height[right] >0) ans += maxRight - height[right];
                right--;
            }
        }
        return ans;
    }
}