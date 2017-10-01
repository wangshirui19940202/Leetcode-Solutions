    // 56. Merge Intervals
    
    public List<Interval> merge(List<Interval> intervals) {
        int[] starts = new int[intervals.size()], ends = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            Interval t = intervals.get(i);
            starts[i] = t.start;
            ends[i] = t.end;
        }
        List<Interval> res = new LinkedList();
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int end = 1, start = 0; end <= starts.length; end++) {
            if (end == starts.length || starts[end] > ends[end - 1]) {
                res.add(new Interval(starts[start], ends[end - 1]));
                start = end;
            }
        }
        return res;
    }
    
    /*
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return intervals;
        Collections.sort(intervals, (a, b) -> {return a.start - b.start;});
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval t = intervals.get(i);
            if (t.start <= cur.end) {
                cur.end = Math.max(cur.end, t.end);
                intervals.remove(t);
                i--;
            } else {
                cur = t;
            }
        }
        return intervals;
    }
    */