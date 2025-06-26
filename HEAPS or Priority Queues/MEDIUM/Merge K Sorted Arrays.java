class Solution {
    static class Node {
        int value, row, col;
        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 0));
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            result.add(current.value);

            int nextCol = current.col + 1;
            if (nextCol < arr[current.row].length) {
                pq.add(new Node(arr[current.row][nextCol], current.row, nextCol));
            }
        }

        return result;
    }
}
