class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int[] res = new int[2];
        while (left<right){
            int cur = nums[left]+nums[right];
            if (cur<target){
                left++;
            } else if (cur==target){
                res[0]=left+1;
                res[1]=right+1;
                return res;
            } else {
                right--;
            }
        }
        return res;
    }
}
