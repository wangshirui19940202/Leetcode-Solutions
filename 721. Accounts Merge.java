    // 721. Accounts Merge

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, HashSet<String>> map = new HashMap();
        for (List<String> list : accounts) {
            for (int i = 1; i < list.size(); i++) {
                if (!map.containsKey(list.get(i))) map.put(list.get(i), new HashSet());
                map.get(list.get(i)).add(list.get(1));
                map.get(list.get(1)).add(list.get(i));
            }
        }
        List<List<String>> res = new ArrayList();
        HashSet<String> visit = new HashSet();
        for (List<String> list : accounts) {
            if (visit.contains(list.get(1))) continue;
            List<String> cur = new ArrayList();
            dfs(list.get(1), map, visit, cur);
            Collections.sort(cur);
            cur.add(0, list.get(0));
            res.add(cur);
        }
        return res;
    }
    
    private void dfs(String cur, HashMap<String, HashSet<String>> map, HashSet<String> visit, List<String> res) {
        res.add(cur);
        visit.add(cur);
        for (String s : map.get(cur))
            if (!visit.contains(s))
                dfs(s, map, visit, res);
    }
    