    // 632. Smallest Range

    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[]{0, Integer.MAX_VALUE};
        int size = nums.size();
        //int[3]  0 - val   1 - index   2 - which
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int max = nums.get(0).get(0);
        for(int i = 0; i < size; i++) {
            pq.add(new int[]{nums.get(i).get(0), 0, i});
            max = Math.max(max, nums.get(i).get(0));
        }
        
        while(pq.size() == size) {
            int[] cur = pq.poll();
            if(res[1] - res[0] > max - cur[0] || (res[1] - res[0] == max - cur[0] && res[0] > cur[0])){
                res[0] = cur[0];
                res[1] = max;
            }
            if(++ cur[1] < nums.get(cur[2]).size()) {
                cur[0] = nums.get(cur[2]).get(cur[1]);
                pq.add(cur);
                max = Math.max(max, cur[0]);
            }
        }
        return res;
    }