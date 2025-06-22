class Solution {
    public int celebrity(int mat[][]) {
        int top=0,bottom=mat.length-1;
        while (top < bottom) {
            if (mat[top][bottom] == 1) {
                top++;
            } else {
                bottom--;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (i == top) continue;
            if (mat[top][i] == 1 || mat[i][top] == 0) return -1;
        }
        
        return top;
    }
}