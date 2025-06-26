class Solution {
    public boolean checkValidString(String s) {
        int low =0, high = 0;
        for (char c: s.toCharArray()){
            if (c == '('){
                low += 1;
                high += 1;
            }
            else if (c == ')'){
                if (low > 0) low -= 1;
                high -= 1;
            }
            else{
                if (low > 0) low -= 1;
                high += 1;
            }
            if (high < 0) return false;
        }
        return low == 0;
    }
}