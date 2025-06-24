class Solution {
    public int minimumRounds(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int operations = 0;
        
        for (HashMap.Entry<Integer, Integer> e: freq.entrySet()) {
            int count = e.getValue();
            if (count == 1) {
                return -1;
            }
            
            operations += (count + 2) / 3;
        }
        
        return operations;
    }
}