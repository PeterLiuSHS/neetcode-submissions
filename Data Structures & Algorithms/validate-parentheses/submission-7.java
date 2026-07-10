class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(')');
            } else if (c == '{') {
                stk.push('}');
            } else if (c == '[') {
                stk.push(']');
            } else if (stk.isEmpty() || c != stk.peek()) {
                return false;
            } else if (!stk.isEmpty() && c == stk.peek()){
                stk.pop();
            }
        }
        if (stk.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
