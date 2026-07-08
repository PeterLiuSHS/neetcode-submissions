class Solution {
    public int findMin(int[] nums) {
        int right = nums.length-1;
        int left = 0, mid=0;
        while (left < right) {
            mid = left + (right - left) / 2;
            int ele = nums[mid];
            if (ele > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
