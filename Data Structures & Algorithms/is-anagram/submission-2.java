class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hs = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (hs.containsKey(c)) {
                hs.put(c, hs.get(c) + 1);
            } else {
                hs.put(c, 1);
            }
        }
        for (char ele : t.toCharArray()) {
            if (hs.containsKey(ele)) {
                hs.put(ele, hs.get(ele) - 1);
            } else {
                return false;
            }
        }
        for (Character key:hs.keySet()){
            if (hs.get(key)!=0){
                return false;
            }
        }

        return true;
    }
}
