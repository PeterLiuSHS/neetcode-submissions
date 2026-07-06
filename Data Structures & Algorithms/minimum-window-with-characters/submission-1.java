class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 走到这里，我们就拿到了全部目标t里面，需要的字符以及对应的数量了
        Map<Character, Integer> window = new HashMap<>();
        // 这是新建的一个哈希表，是用来看窗口里面的情况的
        int required = need.size(); // 这里只是获得need里面有多少个字符
        int formed = 0;
        int  start = 0;
        int answerStart = 0; //****
        int minLen = 9999;

        for (int right = 0; right < s.length(); right++) {
            char charRight = s.charAt(right);
            window.put(charRight, window.getOrDefault(charRight, 0) + 1);

            if (need.containsKey(charRight)
                && window.get(charRight).intValue() == need.get(charRight).intValue()) {
                formed++;
            }

            while (formed==need.size()){
                int len = right - start +1;
                if (len<minLen){
                    minLen = len;
                    answerStart = start; //***
                }
                char charLeft = s.charAt(start);

                window.put(charLeft, window.get(charLeft)-1); //***

                if (need.containsKey(charLeft) && 
                window.get(charLeft).intValue() < need.get(charLeft).intValue()){
                    formed--;
                }
                start++;
            }
        }
        if (minLen==9999){
            return "";
        }
        return s.substring(answerStart, answerStart+minLen);
    }
}
