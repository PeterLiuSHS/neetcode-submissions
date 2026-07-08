class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int mid = 0, left = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                return mid;
            } else {
                if (cur > nums[right]) {
                    // 此时左半边是升序的
                    if (nums[left] <= target && nums[mid] >= target) {
                        right = mid-1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // 此时右半边是升序的
                    if (nums[mid] <= target && nums[right] >= target) {
                        left = mid+1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        if (left==right){
            if (nums[left]==target){
                return left;
            } else {
                return -1;
            }
        }
        
        return -1;
    }
}
