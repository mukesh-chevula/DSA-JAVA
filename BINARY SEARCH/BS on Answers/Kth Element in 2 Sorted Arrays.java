// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        if (b.length<a.length) return kthElement(b,a,k);
        int m=a.length,n=b.length;
        
        int left=k;
        
        int low=Math.max(0,k-n),high=Math.min(k,m);
        
        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            
            int l1=Integer.MIN_VALUE,r1=Integer.MAX_VALUE;
            int l2=Integer.MIN_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<m) r1=a[mid1];
            if(mid2<n) r2=b[mid2];
            
            if(mid1-1>=0) l1=a[mid1-1];
            if(mid2-1>=0) l2=b[mid2-1];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}