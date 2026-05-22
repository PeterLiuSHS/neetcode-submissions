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
        List<String> res = new ArrayList<>();
        int i=0;
        while (i<str.length()){
            int j = i;
            while (str.charAt(j)!='#'){
                // 如果j所在的char不是#,就往前走
                j++;
            }
            // 行至此处，i位于数字的首位，j已经位于#了
            int nums = 0;
            for (int k=i; k<j; k++){
                nums= nums*10+(str.charAt(k)-'0');
            }
            // 找到nums之后，开始提取字符串
            String word = str.substring(j+1, j+1+nums);
            res.add(word);
            i = j+1+nums;
        }
        return res;
    }
}
