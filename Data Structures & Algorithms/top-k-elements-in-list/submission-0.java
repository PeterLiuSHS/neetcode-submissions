class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num:nums){
            if (hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            } else {
                hm.put(num, 1);
            }
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key:hm.keySet()){
            int val = hm.get(key);  // 这是找到，这个key对应出现了几次。
            // 次数将会成为bucket这个数组的下标
            // 现在bucket里的每个元素，都还是null，需要先重置，然后才能往里add
            if (bucket[val]==null){
                List<Integer> newList = new ArrayList<>();
                newList.add(key);
                bucket[val]=newList;
            } else {
                // 也就是说 bucket[val]的位置上，已经有一个ArrayList<>()放在那里了。往里加就行
                bucket[val].add(key);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i=nums.length; i>0 && idx<k; i--){
            if (bucket[i]==null) continue;
            for (int num:bucket[i]){
                res[idx]=num;
                idx++;
            }
        }
        return res;
    }
}
