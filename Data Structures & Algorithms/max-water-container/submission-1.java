class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while (left<right){
            int kuan = right-left;
            int gao = Math.min(heights[left], heights[right]);
            int area = kuan*gao;
            if (heights[left]<=heights[right]){
                left++;
            } else if (heights[left]>=heights[right]){
                right--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
