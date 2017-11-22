    // 79. Word Search

public class Solution {
    /*
    public boolean exist(char[][] board, String word) {
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visit = new boolean[board.length][board[0].length];
        char[] ss = word.toCharArray();
        for (int x = 0; x < board.length; x ++)
            for (int y = 0; y < board[0].length; y ++)
                if (dfs(ss, 0, board, visit, x, y, dir))
                    return true;
        return false;
    }
    private boolean dfs (char[] word, int cur, char[][] board, boolean[][] visit, int x, int y, int[][] dir) {
        if (cur == word.length) return true;
        if (x < 0 || y < 0 || x == board.length || y == board[0].length || visit[x][y] || board[x][y] != word[cur]) return false;
        visit[x][y] = true;
        for (int[] d : dir) 
            if (dfs(word, cur + 1, board, visit, x + d[0], y + d[1], dir))
                return true;
        visit[x][y] = false;
        return false;
    }
    */
    
    // without visit
    public boolean exist(char[][] board, String word) {
        char[] ss = word.toCharArray();
        for(int x=0; x<board.length; x++)
            for(int y=0 ; y<board[0].length; y++)
                if(dfs(board, ss, 0, x, y ))
                    return true;
        return false;
    }
    private boolean dfs(char[][] board, char[] ss, int cur, int x, int y ){
        if(cur == ss.length) return true;
        if(x<0 || y<0 || x==board.length || y==board[0].length || ss[cur] != board[x][y]) 
            return false;
        char o = board[x][y];
        board[x][y] = '0'; // input only contains letters, so change it to a number.
        
        if(dfs(board, ss, cur+1, x+1, y )) return true;
        if(dfs(board, ss, cur+1, x-1, y )) return true;
        if(dfs(board, ss, cur+1, x, y+1 )) return true;
        if(dfs(board, ss, cur+1, x, y-1 )) return true;
        
        board[x][y] = o;
        return false;
    }
    

}