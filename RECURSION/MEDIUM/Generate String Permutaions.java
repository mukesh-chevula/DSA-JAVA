public class Solution {
    public List<String> generateStringPermutations(String str) {
        List<String> result = new ArrayList<>();
        helper(str, "", result);
        return result;
    }

    private void helper(String str, String current, List<String> result) {
        if (str.length() == 0) {
            result.add(current);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            helper(remaining, current + ch, result);
        }
    }
}