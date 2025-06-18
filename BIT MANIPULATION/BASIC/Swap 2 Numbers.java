class Solution {
    static List<Integer> get(int a, int b) {
        // code here
        a=a^b;
        b=a^b;
        a=a^b;
        List<Integer> res=new ArrayList<>();
        res.add(a);
        res.add(b);
        return res;
    }
}