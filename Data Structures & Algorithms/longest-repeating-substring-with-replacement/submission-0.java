class Solution {
    public int characterReplacement(String s, int k) {
        char[] chars = new char[26];
        int left = 0;
        int maxFreq = 0;
        int res = 0;
        for (int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            chars[c-'A']++;
            maxFreq = Math.max(maxFreq, chars[c-'A']);
            while ((right-left+1)-maxFreq > k){
                // 此时窗口不合法
                // 先记录左侧的字符是啥
                char leftChar = s.charAt(left);
                chars[leftChar - 'A']--;
                left++;
            }
            // 现在窗口合法了
            // 更新res
            res = Math.max(res, right-left+1);

        }
        return res;
    }
}
