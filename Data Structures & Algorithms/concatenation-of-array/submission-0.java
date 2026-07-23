class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];
        for (int i=0; i<n; i++){
            res[i]=nums[i];
        }
        for (int j=n; j<2*n; j++){
            int k = j-n;
            res[j]=nums[k];
        }
        return res;
    }
}