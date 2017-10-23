    // 140. Word Break II

    int dictMax = -1; // longest word in dictionary
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet();
        for (String t : wordDict) {
            dict.add(t);
            dictMax = Math.max(dictMax, t.length());
        }
        List<String> res = new LinkedList();
        backtrack(s, dict, new LinkedList(), res, new HashSet());
        return res;
    }
    private boolean backtrack(String s, HashSet<String> dict, LinkedList<String> list, List<String> res, HashSet<String> invalidVisit) {
        if (invalidVisit.contains(s)) return false;
        if (s.length() == 0) {
            StringBuilder sb = new StringBuilder();
            for (String t : list) sb.append(t + " ");
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return true;
        }
        boolean hasRes = false;
        for (int i = 1; i <= dictMax && i <= s.length(); i++) {
            String cur = s.substring(0, i);
            if (dict.contains(cur)) {
                list.add(cur);
                if (backtrack(s.substring(i), dict, list, res, invalidVisit))
                    hasRes = true;
                list.removeLast();
            }
        }
        if (!hasRes) invalidVisit.add(s);
        return hasRes;
    }
    