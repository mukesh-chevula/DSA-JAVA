class Solution {
    public static int totalElements(int[] arr,int k) {
        // code here
        if (k == 0) return 0;
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        int res=0,l=0,r=0;
        
        while(r<arr.length){
            int num=arr[r];
            
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            
            while (freqMap.size() > k) {
                freqMap.put(arr[l], freqMap.get(arr[l]) - 1);
                if (freqMap.get(arr[l]) == 0) {
                    freqMap.remove(arr[l]);
                }
                l++;
            }
            
            res += r - l + 1;
            r++;
        }
        return res;
    }
    public int subarraysWithKDistinct(int[] arr, int k) {
        return totalElements(arr,k)-totalElements(arr,k-1);
    }
}