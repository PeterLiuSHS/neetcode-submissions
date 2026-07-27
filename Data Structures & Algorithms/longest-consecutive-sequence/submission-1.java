class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num:nums){
            hs.add(num);
        }
        int longest = 0;
        for (int num:hs){
            if (!hs.contains(num-1)){
                // 那么说明，num是起点
                int current = num;
                int length = 1;

                while (hs.contains(current+1)){
                    current++;
                    length++;
                }

                // 全部走完了，也就能发现最大值了
                longest= Math.max(longest, length);
            }
            // 那如果hs.contains(num-1)呢？也就是else 的情况，说明还有更小的，直接跳过
            
        }
        return longest;

    }
}
