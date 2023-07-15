class Solution {
    public void solve(char[][] board) {
        char[][] ans = new char[board.length][board[0].length];

        if (board == null || board.length == 0) {
            return;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0,ans);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1,ans);
            }
        }
        
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j,ans);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j,ans);
            }
        }
        
       
      
        
       for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(ans[i][j]=='\u0000'){
                    board[i][j]='X';
                    continue;
                }
                board[i][j] = ans[i][j];
            }
        }
    } 
    
    
    public static void dfs(char[][]board,int i,int j,char[][]ans){
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return;
        }
        
        if(ans[i][j]!='\u0000'){
            return;
        }
        if(board[i][j]=='X'){
            ans[i][j]='X';
            return;
        }
        ans[i][j]='O';
        dfs(board,i+1,j,ans);
        dfs(board,i,j+1,ans);
        dfs(board,i-1,j,ans);
        dfs(board,i,j-1,ans);
        return;
    }
}