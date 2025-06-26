// User function Template for Java

class Solution {

    public boolean countSub(long arr[], long n) {
        // Your code goes here
        for(long i=0;i<n;i++){
            long ele=arr[(int)i];
            long ch1=2*i+1,ch2=2*i+2;
            if(ch1<n && arr[(int)ch1]>ele) return false;
            if(ch2<n && arr[(int)ch2]>ele) return false;
        }
        return true;
    }
}