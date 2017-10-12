    // 59. Spiral Matrix II

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        fill(res, 0, n, 1);
        return res;
    }
    private void fill(int[][] res, int start, int length, int startNum) {
        if (length < 1) return;
        int s = start, e = start + length;
        for (int i = s; i < e; i++)
            res[start][i] = startNum++;
        for (int i = s + 1; i < e; i++)
            res[i][e - 1] = startNum++;
        for (int i = e - 2; i >= s; i--)
            res[e - 1][i] = startNum++;
        for (int i = e - 2; i > s; i--)
            res[i][s] = startNum++;
        fill(res, start + 1, length - 2, startNum);
    }