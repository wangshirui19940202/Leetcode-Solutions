    // 451. Sort Characters By Frequency

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue( new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer>  b) {
                return b.getValue() - a.getValue();
            }
        });
        for(Map.Entry<Character, Integer> entry : map.entrySet()) 
            pq.add(entry);
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            for(int i = 0; i < entry.getValue(); i++)
                sb.append(entry.getKey());
        }
        return sb.toString();
    }