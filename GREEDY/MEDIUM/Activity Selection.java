class Solution {

    static class Activity {
        int start;
        int end;
        int originalPos;

        public Activity(int start, int end, int originalPos) {
            this.start = start;
            this.end = end;
            this.originalPos = originalPos;
        }
    }

    public int activitySelection(int[] start, int[] finish) {
        int n=start.length;
        Activity[] activities = new Activity[n];
        
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], finish[i], i);
        }

        Arrays.sort(activities, (a, b) -> a.end - b.end);

        int count = 1;
        int lastFinishTime = activities[0].end;

        for (int i = 1; i < n; i++) {
            if (activities[i].start > lastFinishTime) {
                count++;
                lastFinishTime = activities[i].end;
            }
        }

        return count;
    }
}
