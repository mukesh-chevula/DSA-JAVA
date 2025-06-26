class Solution {
    public boolean winnerOfGame(String colors) {
        char[] charArr = colors.toCharArray();

        if (charArr.length == 1 || charArr.length == 2) {
            return false;
        }

        int aMoves = 0;
        int bMoves = 0;
        char curr = charArr[0];
        int currCount = 1;
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] == curr) {
                currCount++;
            } else {
                if (curr == 'A') {
                    aMoves += Math.max(0, currCount - 2);
                } else {
                    bMoves += Math.max(0, currCount - 2);
                }
                curr = charArr[i];
                currCount = 1;
            }
        }
        if (curr == 'A') {
            aMoves += Math.max(0, currCount - 2);
        } else {
            bMoves += Math.max(0, currCount - 2);
        }

        return aMoves > bMoves;
    }
}