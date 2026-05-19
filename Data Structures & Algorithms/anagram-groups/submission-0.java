class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s:strs){
            // 第一步，把一个String转换成char构成的数组
            char[] c = s.toCharArray();
            // 第二步，把这个char[]数组，按照字母顺序排列
            Arrays.sort(c);
            // 第三步，把这个char[]数组重新变成一个String
            String key = new String(c);
            // 第四步，去hashmap里面看看有没有这个key
            if (hm.containsKey(key)){
                // hm.get(key) 是拿到了那个list，然后再往里add，构成了新的value
                hm.get(key).add(s);
            } else {
                // 如果list里没有，怎么办呢？于是就只有新造了
                hm.put(key, new ArrayList<>());
                // 造完了再往里放
                hm.get(key).add(s);
            }
        }
        // 现在全部走完之后，就是对应的每个整理后的内容as key，配上一个list里，装满了全部的单词了
        // 那我要新造一个容器来装结果呀
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : hm.values()){
            res.add(list);
        }
        return res;
    }
}
