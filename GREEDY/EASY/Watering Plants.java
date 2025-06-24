class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int curCap=capacity,res=0,n=plants.length;

        for (int i = 0; i < n; i++) {
            if (curCap >= plants[i]) {
                curCap -= plants[i];
                res++;
            } else {
                res += 2 * i + 1;
                curCap = capacity - plants[i];
            }
        }
        return res;
    }
}