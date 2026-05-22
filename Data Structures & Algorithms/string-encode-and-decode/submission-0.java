class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // 首先构造了一个变长数组
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i<str.length()){
            int j = i;
            while (str.charAt(j)!='#'){
                j++;
            }
            // 走到此处，i位于数字的首位，j就已经位于#了，我们尝试拿到数字
            int num = 0;
            for (int k = i; k<j; k++){
                num=num*10+(str.charAt(k)-'0');
            }
            // 此时，j位于#处。j+1是第一个字符。然后我们要拿到总共num个字符
            // int len = Integer.parseInt(s.substring(i,j));
            String word = str.substring(j+1, j+1+num);
            res.add(word);
            i = j+1+num;
        }
        return res;
    }
}
