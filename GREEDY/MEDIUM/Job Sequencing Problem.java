class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
            jobs[i][2] = i;
        }
        
        Arrays.sort(jobs, (a, b) -> b[0] - a[0]);
        
        boolean[] slot = new boolean[10001];
        
        int jobCount = 0;
        int totalProfit = 0;
        
        for (int i = 0; i < n; i++) {
            int jobProfit = jobs[i][0];
            int jobDeadline = jobs[i][1];
            
            for (int j = jobDeadline; j >= 1; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    jobCount++;
                    totalProfit += jobProfit;
                    break;
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount);
        result.add(totalProfit);
        return result;
    }
}