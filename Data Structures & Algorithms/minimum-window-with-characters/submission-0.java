class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int required = need.size();
        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int answerStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if (need.containsKey(rightChar)
                && window.get(rightChar).intValue() == need.get(rightChar).intValue()) {
                formed++;
            }

            while (formed == required) {
                int currentLen = right - left + 1;

                if (currentLen < minLen) {
                    minLen = currentLen;
                    answerStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar)
                    && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(answerStart, answerStart+minLen);
    }
}
