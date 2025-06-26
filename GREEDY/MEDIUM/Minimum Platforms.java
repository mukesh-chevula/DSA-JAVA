// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n=arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int a=0,d=0,maxC=0,c=0;
        
        while(a<n){
            if(arr[a]>dep[d]){
                c--;
                d++;
            }else{
                c++;
                a++;
            }
            maxC=Math.max(maxC,c);
        }
        return maxC;
    }
}
