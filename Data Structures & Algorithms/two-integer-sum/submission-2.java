class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[2];
        // 里面放的是index-value和差的值-key
        for (int i=0; i<nums.length; i++){
            
            if (!hm.isEmpty()){
                if (hm.containsKey(target-nums[i])){
                    res[0]=hm.get(target-nums[i]);
                    res[1]=i;
                }
            }
            hm.put(nums[i], i);
        }
        return res;
    }
}
