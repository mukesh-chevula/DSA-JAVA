class Solution {
    public int helper(String s,int sign,int index, int res){
        if(sign*res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

        if(sign*res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if(index>=s.length() || s.charAt(index)<'0' || s.charAt(index)>'9') return sign*res;

        int digit = s.charAt(index) - '0';
        if (res > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        res=helper(s,sign,index+1,res*10+(s.charAt(index)-'0'));

        return res;
    }
    public int myAtoi(String s) {
        int i=0,n=s.length(),sign=1;

        if (s == null || s.trim().isEmpty()) return 0;

        s = s.trim();

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        if (i >= s.length() || s.charAt(i) < '0' || s.charAt(i) > '9') return 0;

        return helper(s,sign,i,0);
    }
}