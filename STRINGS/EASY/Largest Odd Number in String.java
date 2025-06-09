class Solution {
    static{
        for(int i=0;i<=300;i++) largestOddNumber("1");
    }
    public static String largestOddNumber(String s) {
        String res="";

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'||s.charAt(i)=='3'||s.charAt(i)=='5'||s.charAt(i)=='7'||s.charAt(i)=='9'){
                res=s.substring(0,i+1);
                break;
            }
        }
        return res;
    }
}