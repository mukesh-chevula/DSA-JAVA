class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length,currentHeight,height,width;

        for (int i = 0; i <= n; i++) {
            if(i==n){
                currentHeight=0;
            }else{
                currentHeight=heights[i];
            }

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                height = heights[stack.pop()];
                if(stack.isEmpty()){
                    width=i;
                }else{
                    width= i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int rows=matrix.length,cols=matrix[0].length;
        int[][] prefix=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    prefix[i][j] = (i > 0 ? prefix[i - 1][j] : 0) + 1;
                }else{
                    prefix[i][j]=0;
                }
            }
        }
        int max=0;
        for(int[] row:prefix){
            max=Math.max(max,largestRectangleArea(row));
        }
        return max;
    }
}