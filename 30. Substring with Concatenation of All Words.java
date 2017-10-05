    // 30. Substring with Concatenation of All Words
    
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) return new LinkedList();
        List<Integer> res = new LinkedList();
        int wordLen = words[0].length();
        HashMap<String, Integer> oriMap = new HashMap(), curMap = new HashMap();
        for (String t : words)
            oriMap.put(t, oriMap.getOrDefault(t, 0) + 1);
        for (int i = 0; i < wordLen; i++) {
            int count = 0;
            for (int l = i, r = i; r <= s.length() - wordLen; r += wordLen) {
                String cur = s.substring(r, r + wordLen);
                if (oriMap.containsKey(cur)) {
                    count ++;
                    curMap.put(cur, curMap.getOrDefault(cur, 0) + 1);
                    while (curMap.get(cur) > oriMap.get(cur)) {
                        String removeStr = s.substring(l, l + wordLen);
                        curMap.put(removeStr, curMap.get(removeStr) - 1);
                        l += wordLen;
                        count--;
                    }
                    if (count == words.length)
                        res.add(l);
                } else {
                    curMap.clear();
                    count = 0;
                    l = r + wordLen;
                }
            }
            curMap.clear();
        }
        return res;
    }