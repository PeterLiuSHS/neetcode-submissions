class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 数是往前走的。但是如果这个数等于前一个数，那么就说明，这个数在前面我们已经考察过了
                continue;
            }
            int left = i+1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // 但是，还有可能是后面还有合适的结果
                    while (left < right && nums[left] == nums[left - 1]) {
                        // 时刻谨记，数字是往前走的，所以要看这个数和前一个数是否相等
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }
        return res;
    }
}
