    // 37. Sudoku Solver
    
    public void solveSudoku(char[][] board) {
        backtrack(board);
        return;
    }
    
    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    board[i][j] = c;
                    if (valid(board, i, j)) 
                        if (backtrack(board)) return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean valid(char[][] board, int m, int n) {
        int sx = (m / 3) * 3, sy = (n / 3) * 3;
        for(int i = 0; i < 9; i++) {
            if((i != n && board[m][i] == board[m][n]) || (i != m && board[i][n] == board[m][n])) return false;
            int cx = sx + i / 3, cy = sy + i % 3;
            if(cx != m && cy != n && board[cx][cy] == board[m][n]) return false;
        }
        return true;
    }