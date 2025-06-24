class Solution {
    public String breakPalindrome(String palindrome) {
        int n=palindrome.length();
        if(n==1){
            return "";
        }
        
        for(int i=0;i<n;i++){
            if(palindrome.charAt(i)!='a' && !(n%2!=0 && i==n/2)){
                palindrome=palindrome.substring(0,i)+'a'+palindrome.substring(i+1);
                return palindrome;
            }
        }
        
        palindrome=palindrome.substring(0,n-1)+'b';
        
        return palindrome;
    }
}