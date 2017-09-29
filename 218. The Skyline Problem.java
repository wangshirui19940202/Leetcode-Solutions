    // 218. The Skyline Problem

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList();
        ArrayList<int[]> list = new ArrayList();
        for(int[] i : buildings) {
            list.add(new int[]{i[0], i[2]});
            list.add(new int[]{i[1], -i[2]});
        }
        Collections.sort(list, (a, b) -> {return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];});
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        treeMap.put(0, 1);
        int height = 0;
        for(int[] i : list) {
            if(i[1] > 0) {
                treeMap.put(i[1], treeMap.getOrDefault(i[1], 0) + 1);
            } else {
                int count = treeMap.get(-i[1]);
                if(count == 1)
                    treeMap.remove(-i[1]);
                else 
                    treeMap.put(-i[1], count - 1);
            }
            if(height != treeMap.lastEntry().getKey()) {
                height = treeMap.lastEntry().getKey();
                res.add(new int[]{i[0], height});
            }
        }
        return res;
    }
    
    /*
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<>();
        ArrayList<int[]> height = new ArrayList<>();
        for(int [] b : buildings){
            height.add(new int[]{b[0], b[2]});
            height.add(new int[]{b[1], -b[2]});
        }
        Collections.sort(height, (a,b) -> {
            return a[0]==b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int pre = 0;
        pq.add(0);
        for(int[] cur: height){
            if(cur[1] > 0)
                pq.add(cur[1]);
            else
                pq.remove(-cur[1]);
            int next = pq.peek();
            if(next != pre){
                res.add(new int[]{cur[0], next});
                pre = next;
            }
            
        }
        return res;
    }
    */