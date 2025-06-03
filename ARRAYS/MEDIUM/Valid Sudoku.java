class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] nums =new boolean[9];

        Arrays.fill(nums,false);

        //row checking
        for(char[] row : board){
            Arrays.fill(nums,false);
            for(int i=0;i<9;i++){
                if(!Character.valueOf(row[i]).equals('.')){
                    int num = row[i]-'0';
                    if(nums[num-1]==true){
                        return false;
                    }
                    nums[num-1]=true;
                }
            }
        }

        //col checking
        for(int i=0;i<9;i++){
            Arrays.fill(nums,false);
            for(int j=0;j<9;j++){
                if(!Character.valueOf(board[j][i]).equals('.')){
                    int num = board[j][i]-'0';
                    if(nums[num-1]==true){
                        return false;
                    }
                    nums[num-1]=true;
                }
            }
        }

        //3x3 checking
        for (int i = 0; i < 9; i++) {
            Arrays.fill(nums, false);  
            int rowStart = (i / 3) * 3;
            int colStart = (i % 3) * 3;

            for (int r = rowStart; r < rowStart + 3; r++) {
                for (int c = colStart; c < colStart + 3; c++) {
                    if (board[r][c] != '.') { 
                        int num = board[r][c] - '0';  
                        if (nums[num - 1]) {  
                            return false;
                        }
                        nums[num - 1] = true; 
                    }
                }
            }
        }


        return true;
    }
}