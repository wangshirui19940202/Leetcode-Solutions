    // 692. Top K Frequent Words
    
    // bucketsort, much faster, worst case O(NlogN)
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList();
        HashMap<String, Integer> hash = new HashMap();
        for (String s : words) 
            hash.put(s, hash.getOrDefault(s, 0) + 1);
        ArrayList<String>[] bucket = new ArrayList[words.length];
        for (Map.Entry<String, Integer> e : hash.entrySet()) {
            if (bucket[e.getValue()] == null) bucket[e.getValue()] = new ArrayList();
            bucket[e.getValue()].add(e.getKey());
        }
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                if (res.size() + bucket[i].size() < k) {
                    res.addAll(bucket[i]);
                } else {
                    int index = 0;
                    while (res.size() != k) res.add(bucket[i].get(index++));
                    break;
                }
            }
        }
        return res;
    }
    
    /*
    // heap, O(NlogK)
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList();
        HashMap<String, Integer> hash = new HashMap();
        for (String s : words)
            hash.put(s, hash.getOrDefault(s, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>((a, b) -> (a.getValue() == b.getValue()? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
        for (Map.Entry<String, Integer> e : hash.entrySet()) {
            pq.add(e);
            if (pq.size() > k) pq.remove();
        }
        while (!pq.isEmpty())
            res.add(0, pq.remove().getKey());
        return res;
    }
    */