class Solution {
    public int maxDiff(int num) {
        String str = String.valueOf(num);
        
        StringBuilder maxStr = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                char target = str.charAt(i);
                for (int j = 0; j < maxStr.length(); j++) {
                    if (maxStr.charAt(j) == target) {
                        maxStr.setCharAt(j, '9');
                    }
                }
                break;
            }
        }
        
        StringBuilder minStr = new StringBuilder(str);
        if (str.charAt(0) != '1') {
            char target = str.charAt(0);
            for (int j = 0; j < minStr.length(); j++) {
                if (minStr.charAt(j) == target) {
                    minStr.setCharAt(j, '1');
                }
            }
        } else {
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != '1' && str.charAt(i) != '0') {
                    char target = str.charAt(i);
                    for (int j = 0; j < minStr.length(); j++) {
                        if (minStr.charAt(j) == target) {
                            minStr.setCharAt(j, '0');
                        }
                    }
                    break;
                }
            }
        }
        
        int maxVal = Integer.parseInt(maxStr.toString());
        int minVal = Integer.parseInt(minStr.toString());
        
        return maxVal - minVal;
    }
}