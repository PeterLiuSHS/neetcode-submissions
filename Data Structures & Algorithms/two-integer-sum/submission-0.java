class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = nums.length;
        int[] res = new int[2];
        for (int i=0; i<len; i++){
            int cur = nums[i];
            int key = target-nums[i];   // 我要把需要的数放到key里，然后在value里放i
            if (hm.containsKey(key)){
                res[1]=i;
                res[0]=hm.get(key);
            } else {
                hm.put(cur, i);
            }
        }
        return res;
    }
}
