class Solution {
    public void _solveNQueens(List<List<String>> res,List<Integer> queens,boolean[] cols,boolean[] diag_diff,boolean[] diag_sum,int n) {
        int row=queens.size();
        if (row==n) {
            List<String> board=new ArrayList<>();
            for (int i=0;i<n;i++) {
                char[] rowArray=new char[n];
                Arrays.fill(rowArray,'.');
                rowArray[queens.get(i)]='Q';
                board.add(new String(rowArray));
            }
            res.add(board);
            return;
        }
        for (int col=0;col<n;col++) {
            if (!cols[col]&&!diag_diff[row-col+n-1]&&!diag_sum[row+col]) {
                queens.add(col);
                cols[col]=true;
                diag_diff[row-col+n-1]=true;
                diag_sum[row+col]=true;
                _solveNQueens(res,queens,cols,diag_diff,diag_sum,n);
                queens.remove(queens.size()-1);
                cols[col]=false;
                diag_diff[row-col+n-1]=false;
                diag_sum[row+col]=false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        _solveNQueens(res,new ArrayList<>(),new boolean[n],new boolean[2*n-1],new boolean[2*n-1],n);
        return res;
    }
}