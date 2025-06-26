class Solution {
    public int maximum69Number (int num) {
        int t=num;
        int pos=0;
        int pos6=-1;
        while(t>0){
            int rem=t%10;
            t=t/10;
            if(rem==6) pos6=pos;
            pos++;
        }
        return pos6==-1 ? num : num + 3 * (int)Math.pow(10, pos6);
    }
}