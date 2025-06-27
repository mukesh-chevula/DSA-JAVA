class Element {
    int index;
    int value;
    int absDiff;

    Element(int index, int value, int absDiff) {
        this.index = index;
        this.value = value;
        this.absDiff = absDiff;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Element> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.absDiff == b.absDiff) {
                    return a.value - b.value;
                }
                return a.absDiff - b.absDiff;
            }
        );

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Element(i, arr[i], Math.abs(arr[i] - x)));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().value);
        }

        Collections.sort(result);

        return result;
    }
}

