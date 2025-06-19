public class Solution {
    public static int goodCells(int[][] v) {
        // Write your code here.
        int n=v.length;
        int m=v[0].length;
        int c=0;

        for(int i=0;i<v.length;i++){
            for(int j=0;j<v[0].length;j++){
                int rxor=0;
                int cxor=0;
                for(int k=0;k<n;k++){
                    rxor^=v[i][k];
                }
                for(int k=0;k<m;k++){
                    cxor^=v[k][i];
                }
                if(rxor==cxor) c++;
            }
        }
        return c;
    }

}