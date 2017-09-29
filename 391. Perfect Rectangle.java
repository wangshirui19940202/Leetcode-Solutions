    // 391. Perfect Rectangle

    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0) return false;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE, u =  Integer.MIN_VALUE, b = Integer.MAX_VALUE; 
        int area = 0;
        HashSet<String> set = new HashSet();
        for (int[] i : rectangles) {
            l = Math.min(l, i[0]);
            r = Math.max(r, i[2]);
            u = Math.max(u, i[3]);
            b = Math.min(b, i[1]);
            area += (i[2] - i[0]) * (i[3] - i[1]);
            if(!set.add(i[0] + " " + i[1])) set.remove(i[0] + " " + i[1]);
            if(!set.add(i[2] + " " + i[3])) set.remove(i[2] + " " + i[3]);
            if(!set.add(i[0] + " " + i[3])) set.remove(i[0] + " " + i[3]);
            if(!set.add(i[2] + " " + i[1])) set.remove(i[2] + " " + i[1]);
        }
        if(set.size() != 4 || area != (r - l) * (u - b) || !(set.contains(l + " " + u) && set.contains(l + " " + b) && set.contains(r + " " + u) && set.contains(r + " " + b)))
            return false;
        return true;
    }