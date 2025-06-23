import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String s) {
		// Write your code here
		Map<Character, Integer> freqMap = new HashMap<>();
        
        int res=0,l=0,r=0;
        
        while(r<s.length()){
            char ch=s.charAt(r);
            
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            
            while (freqMap.size() > k) {
                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                if (freqMap.get(s.charAt(l)) == 0) {
                    freqMap.remove(s.charAt(l));
                }
                l++;
            }
            
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
	}

}
