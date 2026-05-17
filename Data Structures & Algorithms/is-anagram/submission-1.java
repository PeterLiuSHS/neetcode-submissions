class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1!=len2){
            return false;
        }
        HashMap<Character, Integer> hs = new HashMap<>();
        for (int i = 0; i<len1; i++){
            char ele = s.charAt(i);
            if (hs.containsKey(ele)){
                hs.put(ele, hs.get(ele)+1);
            } else {
                hs.put(ele, 1);
            }
        }
        
        for (int j=0; j<len2; j++){
            char cur = t.charAt(j);
            if (hs.containsKey(cur)){
                if (hs.get(cur)<=0){
                    return false;
                } else{
                    hs.put(cur, hs.get(cur)-1);
                }               
            } else {
                return false;
            }
        }
        return true;
    }
}
