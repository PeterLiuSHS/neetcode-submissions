class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()){ //
            return "";
        } 
        HashMap<Character, Integer> hs = new HashMap<>();
        for (char c : t.toCharArray()){
            hs.put(c, hs.getOrDefault(c, 0)+1);
        }
        int required = hs.size(); 
        int formed = 0;
        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = 5000;
        HashMap<Character, Integer> hs1 = new HashMap<>();
        for  (; right<s.length(); right++){
            char cur = s.charAt(right);
            hs1.put(cur, hs1.getOrDefault(cur, 0)+1);
            if (hs.containsKey(cur) && hs1.get(cur).intValue()==hs.get(cur).intValue()){
                formed++;
            }
            while (formed==required){
                
                if (right-left+1<minLen){                    
                    minLen = right-left+1;
                    start = left;
                }
                char ele = s.charAt(left);
                if (hs.containsKey(ele) && hs1.get(ele).intValue()==hs.get(ele).intValue()){
                    
                    formed--;
                }
                hs1.put(ele, hs1.get(ele)-1); // 只要left往右走，hs1就要减一，不论是否是hs里面所需要的
                left++;
            }
        }
        if (minLen == 5000){
            return "";
        }
        return s.substring(start, start+minLen);

    }
}
