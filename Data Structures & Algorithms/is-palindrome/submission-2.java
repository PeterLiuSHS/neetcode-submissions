class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len-1;
        while (left<right){
            while (!Character.isLetterOrDigit(s.charAt(left)) && (left<right)){
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && (left<right)){
                right--;
            }
            char zuo = Character.toLowerCase(s.charAt(left));
            char you = Character.toLowerCase(s.charAt(right));
            if (zuo==you){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
