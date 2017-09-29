    // 406. Queue Reconstruction by Height
    
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];});
        ArrayList<int[]> list = new ArrayList();
        for(int[] p : people)
            list.add(p[1], p);
        return list.toArray(people);  // 
    }
    
    