class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1; 
        while (left < right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            // 现在，这个target不是mid，一定在左右两边
            if (nums[mid]>nums[right]){
                // 说明左半边是有序的，右半边是先递增，再递减
                if (target>=nums[left] && target<nums[mid]){
                    // 在左半边里面
                    right = mid-1;
                } else {
                    // 在右半边里面
                    left = mid+1;
                }
            } else if (nums[mid]<nums[right]) {
                // 右半边是有序的
                if (target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        if (nums[left]==target){
            return left;
        } else {
            return -1;
        }
    }
}
