class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            sFreq[s.charAt(right) - 'a']++;

            if (right - left + 1 < p.length()) {
                right++;
            } else {
                if (Arrays.equals(sFreq, pFreq)) {
                    result.add(left);
                }
                sFreq[s.charAt(left) - 'a']--;
                left++;
                right++;
            }
        }

        return result;
    }
}