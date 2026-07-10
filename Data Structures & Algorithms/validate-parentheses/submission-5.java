class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            }
            if (stk.isEmpty()) {
                if (c == ')' || c == ']' || c == '}') {
                    return false;
                }
            } else {
                if (c == ')') {
                    if (stk.peek() != '(') {
                        return false;
                    } else {
                        stk.pop();
                    }
                } else if (c == ']') {
                    if (stk.peek() != '[') {
                        return false;
                    } else {
                        stk.pop();
                    }
                } else if (c == '}') {
                    if (stk.peek() != '{') {
                        return false;
                    } else {
                        stk.pop();
                    }
                }
            }
        }
        if (stk.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
