    // 407. Trapping Rain Water II

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2) return 0;
        int res = 0, m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[0] - b[0];}); // int[3] {hright, row, colom}
        boolean[][] visit = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            pq.add(new int[]{heightMap[i][0], i, 0});
            pq.add(new int[]{heightMap[i][n - 1], i, n - 1});
            visit[i][0] = true;
            visit[i][n - 1] = true;
        }
        for(int i = 1; i < n - 1; i++) {
            pq.add(new int[]{heightMap[0][i], 0, i});
            pq.add(new int[]{heightMap[m - 1][i], m - 1, i});
            visit[0][i] = true;
            visit[m - 1][i] = true;
        }
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int level = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            level = Math.max(cur[0], level);
            for(int[] d : dir) {
                int nx = cur[1] + d[0], ny = cur[2] + d[1];
                if(nx < 0 || ny < 0 || nx == m || ny == n || visit[nx][ny]) continue;
                pq.add(new int[]{heightMap[nx][ny], nx, ny});
                res += Math.max(0, level - heightMap[nx][ny]);
                visit[nx][ny] = true;
            }
        }
        return res;
    }