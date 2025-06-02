class Solution {
    public ArrayList<Integer> Union(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
            } else if (a[i] > b[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != b[j]) {
                    res.add(b[j]);
                }
                j++;
            } else {
                if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
                j++;
            }
        }

        while (i < a.length) {
            if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                res.add(a[i]);
            }
            i++;
        }

        while (j < b.length) {
            if (res.isEmpty() || res.get(res.size() - 1) != b[j]) {
                res.add(b[j]);
            }
            j++;
        }

        return res;
    }
}