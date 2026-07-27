class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] grt = new int[n];
        int max = arr[n-1];
        
        for (int i=n-2; i>=0; i--){
            if (arr[i]<max){
                // 此时max不变，依然是右侧的最大值
                grt[i] = max;
            } else if (arr[i] >= max){
                grt[i] = max;
                // 此时max要变，变为此时的最大
                max = arr[i];
            }
        }

        grt[n-1] = -1;
        return grt;
    }
}