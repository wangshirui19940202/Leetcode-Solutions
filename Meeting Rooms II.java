    // Meeting Rooms II

    /*
    public int meetingRoom(Interval[] meetings){ 
        if(meetings.length <= 1) return meetings.length;
        Arrays.sort(meetings, (a, b) -> {return a.start - b.start;});
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {return a.end - b.end;});
        int res = 0;
        for (Interval i : meetings) {
            while(!pq.isEmpty() && pq.peek().end <= i.start)
                pq.poll();
            pq.add(i);
            res = Math.max(res, pq.size());
        }
        return res;
    }
    */
    public int meetingRoom(Interval[] meetings){ 
        if(meetings.length <= 1) return meetings.length;
        int[] starts = new int[meetings.length], ends = new int[meetings.length];
        for(int i = 0; i < meetings.length; i++) {
            starts[i] = meetings[i].start;
            ends[i] = meetings[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0, cur = 0, endindex = 0;
        for (int i = 0; i < starts.length; i++) {
            if(ends[endindex] <= starts[i])
                endindex++;
            else 
                res++;
        }
        return res;
    }