class Solution {
    public int myAtoi(String s) {
        int res=0;
        int sign=1;
        int start=0;
        
        while (start<s.length() && s.charAt(start)==' ') {
            start++;
        }

        if(start<s.length() && (s.charAt(start)=='+' || s.charAt(start)=='-')){
            sign = (s.charAt(start) == '-') ? -1 : 1;
            start++;
        }

        for(int i=start;i<s.length();i++){
            char c=s.charAt(i);
            if (Character.isDigit(c)) {
                int digit=c-'0';
                
                if(res>(Integer.MAX_VALUE-digit)/10) {
                    return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                
                res = res * 10 + digit;
            } else {
                break;  
            }
        }

        return res * sign;
    }
}
