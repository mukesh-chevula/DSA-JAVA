import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c1 = 0, c2 = 0;
        
        for (int i : nums) {
            if (i == a) {
                c1++;
            } else if (i == b) {
                c2++;
            } else if (c1 == 0) {
                a = i;
                c1 = 1;
            } else if (c2 == 0) {
                b = i;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (i == a) {
                c1++;
            } else if (i == b) {
                c2++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (c1 > n / 3) res.add(a);
        if (c2 > n / 3) res.add(b);
        
        return res;
    }
}
