//leetcode 1298

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] opened = new boolean[status.length];
        int res=0;
        for (int box : initialBoxes) {
            queue.add(box);
        }

        int iterations = 0; 
        while (!queue.isEmpty()) {
            if (iterations > 100000) { 
                break;
            }
            iterations++;
            
            int curBox = queue.removeFirst();
            if (opened[curBox]) {
                continue;
            }
            if (status[curBox] == 0) {
                queue.addLast(curBox);
                continue;
            }
            res += candies[curBox];
            opened[curBox] = true;
            for (int i : containedBoxes[curBox]) {
                queue.addLast(i);
            }
            for (int i : keys[curBox]) {
                status[i] = 1;
            }
        }
        return res;
    }
}