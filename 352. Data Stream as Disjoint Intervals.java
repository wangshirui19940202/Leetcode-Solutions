

// 352. Data Stream as Disjoint Intervals

class SummaryRanges {

    TreeMap<Integer, Interval> map;
    
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.containsKey(val)) return;
        Integer l = map.lowerKey(val), h = map.higherKey(val);
        if(l != null && h != null && map.get(l).end == val - 1 && h - 1 == val) {
            map.get(l).end = map.get(h).end;
            map.remove(h);
        } else if(h != null && h - 1 == val) {
            map.put(val, new Interval(val, map.get(h).end));
            map.remove(h);
        } else if(l != null && map.get(l).end + 1 >= val) {
            map.get(l).end = Math.max(val, map.get(l).end);
        } else 
            map.put(val, new Interval(val, val));
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList(map.values());
    }
}