class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num:nums){
            hs.add(num);
        }
        // ok，现在我们拿到了一个hashset，现在开始
        // 第一点，判断这个hs的每个数是否为起点数
        // 第二点，判断这个hs的最大可以走多远
        int maxlen = 0;
        for (int ele:hs){
            int count = 0;
            if (hs.contains(ele-1)){
                // 说明现在这个ele呀，不是一个starter
                // 那我们应该咋办？直接continue吧，后面的都不需要执行了
                continue;
            } else {
                // 那此时ele就是一个小段的起点了
                count++; // 此时多了一个数嘛
                ele++;   // 我让这个自然数也往后走一步
                while (hs.contains(ele)){
                    // 那如果还含有下一个数的话
                    count++;
                    ele++; // 不停循环，直至退出
                }
            }
            if (count>maxlen){
                maxlen = count;
            }
        }
        return maxlen;
    }
}
