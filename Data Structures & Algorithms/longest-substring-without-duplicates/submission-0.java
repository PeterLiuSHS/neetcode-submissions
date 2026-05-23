class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        HashSet<Character> hs = new HashSet<>();
        for (int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            while (hs.contains(c)){
                // 遇到重复的了，开始往外弹
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            maxLen = Math.max(maxLen, hs.size());
        }
        return maxLen;
    }
}
