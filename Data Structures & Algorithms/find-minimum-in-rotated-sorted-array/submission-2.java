class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 说明左半边有序，最小值只可能出现在右半边
                left = mid + 1;
            } else {
                // 说明右半边有序
                right = mid;
            }
        }
        return nums[left];
    }
}
