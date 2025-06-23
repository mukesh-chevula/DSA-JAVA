class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tC=0,tot=0,res=0;

        for(int i=0;i<gas.length;i++){
            tC+=gas[i]-cost[i];
            tot+=gas[i]-cost[i];
            if(tot<0){
                tot=0;
                res=i+1;
            }
        }
        return tC < 0 ? -1 : res;
    }
}