class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        if(n==0){
            return 0;
        }

        int[] time = new int[n];
        for(int i =0;i<n;++i){
            time[i] = (dist[i]-1) / speed[i]; 
        }

        Arrays.sort(time);

        int count=0;
        for(int i=0;i<n;i++){
            if(time[i]<i){
                return i;
            }
        }
        return n;
    }
}