    // 49. Group Anagrams
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, LinkedList<String>> map = new HashMap();
        for(String s : strs) {
            char[] ss = s.toCharArray();
            Arrays.sort(ss);
            String sort = new String(ss);
            LinkedList list = map.getOrDefault(sort, new LinkedList<>());
            list.add(s);
            map.put(sort, list);
        }
        res.addAll(map.values());
        return res;
    }