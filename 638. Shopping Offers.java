    // 638. Shopping Offers
    // dfs with dp

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>, Integer> dp = new HashMap();
        ArrayList<Integer> zeroList = new ArrayList();
        for(int i : needs) 
            zeroList.add(0);
        dp.put(zeroList, 0);
        dfs(price, special, needs, dp);
        return dp.get(needs);
    }
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, HashMap<List<Integer>, Integer> dp) {
        if(dp.containsKey(needs)) return dp.get(needs);
        int res = Integer.MAX_VALUE;
        for(int l = 0; l < special.size(); l++) {
            List<Integer> sp = special.get(l);
            List<Integer> nextNeed = new ArrayList<>(needs);
            boolean usable = true;
            for(int i = 0; i < sp.size() - 1; i++) {
                int nextamount = nextNeed.get(i) - sp.get(i);
                if(nextamount < 0){
                    usable = false;
                    break;
                }
                nextNeed.set(i, nextamount);
            }
            if(!usable) continue;
            res = Math.min(res, sp.get(needs.size()) + dfs(price, special, nextNeed, dp));
        }
        
        int withoutSp = 0;
        for(int i = 0; i < needs.size(); i++)
            withoutSp += price.get(i) * needs.get(i);
        res = Math.min(withoutSp, res);
        dp.put(needs, res);
        return res;
    }