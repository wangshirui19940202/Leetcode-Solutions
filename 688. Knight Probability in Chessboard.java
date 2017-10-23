    // 688. Knight Probability in Chessboard

    public double knightProbability(int N, int K, int r, int c) {
        int[][] dir = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
        double[][] board = new double[N][N];
        for (double[] row : board) Arrays.fill(row, 1);
        for (int t = 0; t < K; t++) {
            double[][] next = new double[N][N];
            for (int i = 0; i < N; i ++)
                for (int j = 0; j < N; j++)
                    for (int[] d : dir) {
                        int nx = i + d[0], ny = j + d[1];
                        if (valid(nx, ny, N)) next[nx][ny] += board[i][j];
                    }
            board = next;
        }
        return board[r][c] / Math.pow(8, K);
    }
    private boolean valid(int x, int y, int N) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }