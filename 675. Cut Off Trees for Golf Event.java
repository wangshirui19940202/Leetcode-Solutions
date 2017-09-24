    // 675. Cut Off Trees for Golf Event
    
    int lastx = 0;
    int lasty = 0;
    
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.size() == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(List<Integer> list : forest)
            for(int i : list)
                if(i > 1) pq.add(i);
        int res = 0;
        while(!pq.isEmpty()) {
            int step = bfs(pq.poll(), lastx, lasty, new boolean[forest.size()][forest.get(0).size()], forest);
            if(step == -1) return -1;
            res +=step;
        }
        return res;
    }
    private int bfs(int target, int x, int y, boolean[][] visit, List<List<Integer>> forest) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int res = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] cur = new int[]{x, y};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                cur = queue.poll();
                if(forest.get(cur[0]).get(cur[1]) == target) {
                    lastx = cur[0];
                    lasty = cur[1];
                    return res;
                }
                visit[cur[0]][cur[1]] = true;
                for(int[] d : dir) {
                    int nx = cur[0] + d[0], ny = cur[1] + d[1];
                    if(nx < 0 || ny < 0 || nx == forest.size() || ny == forest.get(0).size() || visit[nx][ny] || forest.get(nx).get(ny) == 0) continue;
                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
            res++;
        }
        return -1;
    }