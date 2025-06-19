class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        char[] arr = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                arr[++top] = c;          
            } else {
                if (top == -1) return false;
                if ((c == ')' && arr[top] != '(') ||
                    (c == ']' && arr[top] != '[') ||
                    (c == '}' && arr[top] != '{'))
                    return false;                   
                top--;                              
            }
        }
        return top == -1;                           
    }
}