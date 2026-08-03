class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<Integer>> hm = new HashMap<>();
        for (int i=0; i<strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String cur = new String(chars);
            if (hm.containsKey(cur)){
                List<Integer> list=hm.get(cur);
                list.add(i);
                hm.put(cur, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(cur, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        
        for (String ele:hm.keySet()){
            List<String> list = new ArrayList<>();
            for(int idx:hm.get(ele)){
                list.add(strs[idx]);
            }
            res.add(list);
        }
        return res;
    }
}
