class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int gp=0,sp=0;
        int res=0;
        while(gp<g.length && sp<s.length){
            if (s[sp] >= g[gp]) {
                res++;
                gp++;
            }
            sp++;
        }
        return res;
    }
}