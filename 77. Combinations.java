    
// 77. Combinations

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, new LinkedList<Integer>(), 1, n, k);
        return res;
    }
    private void backtrack(List<List<Integer>> res, LinkedList<Integer> list, int cur, int n, int k) {
        if(0 == k) {
            res.add(new LinkedList<Integer>(list));
            return;
        }
        int max = n - k + 1;
        for(int i = cur; i <= max; i++) {
            list.add(i);
            backtrack(res, list, i + 1, n, k - 1);
            list.removeLast();
        }
    }