// User function Template for Java

class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        int res=0,l=0,r=0;
        
        while(r<arr.length){
            int fruit=arr[r];
            
            freqMap.put(fruit, freqMap.getOrDefault(fruit, 0) + 1);
            
            while (freqMap.size() > 2) {
                freqMap.put(arr[l], freqMap.get(arr[l]) - 1);
                if (freqMap.get(arr[l]) == 0) {
                    freqMap.remove(arr[l]);
                }
                l++;
            }
            
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}