class Solution {
    public int mySqrt(int x) {
        int low=1, high=x,mid,sq;

        while(low<=high){
            mid=low+(high-low)/2;
            sq=x/mid;
            if(sq==mid) return mid;
            else if(sq<mid) high=mid-1;
            else low=mid+1;
        }
        return high;
    }
}