    // 89. Gray Code
    // recursive
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList();
        if(n == 0) {
            res.add(0);
            return res;
        }
        List<Integer> last = grayCode(n - 1);
        res.addAll(last);
        int mask = (int) Math.pow(2, n - 1);
        for (int i = last.size() - 1; i >= 0; i--) {
            res.add(last.get(i) + mask);
        }
        return res;
    }