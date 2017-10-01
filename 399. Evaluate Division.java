    // 399. Evaluate Division

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap();
        HashMap<String, ArrayList<Double>> pairValues = new HashMap();
        for (int i = 0; i < values.length; i++) {
            if (!pairs.containsKey(equations[i][0])) {
                pairs.put(equations[i][0], new ArrayList());
                pairValues.put(equations[i][0], new ArrayList());
            }
            if (!pairs.containsKey(equations[i][1])) {
                pairs.put(equations[i][1], new ArrayList());
                pairValues.put(equations[i][1], new ArrayList());
            }
            pairs.get(equations[i][0]).add(equations[i][1]);
            pairValues.get(equations[i][0]).add(values[i]);
            pairs.get(equations[i][1]).add(equations[i][0]);
            pairValues.get(equations[i][1]).add(1 / values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if(pairs.containsKey(queries[i][0]))
                res[i] = dfs(pairs, pairValues, queries[i][0], queries[i][1], new HashSet());
            else 
                res[i] = -1;
        }
        return res;
    }
    private double dfs(HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> pairValues, String cur, String end, HashSet<String> visit) {
        if (cur.equals(end)) return 1;
        ArrayList<String> curPairs = pairs.get(cur);
        for (int i = 0; i < curPairs.size(); i++) {
            String s = curPairs.get(i);
            if (visit.contains(s)) continue;
            visit.add(s);
            double next = dfs(pairs, pairValues, s, end, visit);
            if (next != -1) return next * pairValues.get(cur).get(i);
            visit.remove(s);
        }
        return -1;
    }
    
    
    /*
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String,ArrayList<String>> pairs=new HashMap<>();
        HashMap<String,ArrayList<Double>> pairValues=new HashMap<>();
        
        for (int i=0;i<values.length;i++) {
            String[] pair = equations[i];
            if (!pairs.containsKey(pair[0])) {
                pairs.put(pair[0], new ArrayList<String>());
                pairValues.put(pair[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(pair[1])) {
                pairs.put(pair[1], new ArrayList<String>());
                pairValues.put(pair[1], new ArrayList<Double>());
            }
            pairs.get(pair[0]).add(pair[1]);
            pairs.get(pair[1]).add(pair[0]);
            pairValues.get(pair[0]).add(Double.valueOf(values[i]));
            pairValues.get(pair[1]).add(Double.valueOf(1/values[i]));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            double t = calcEquationDFS(queries[i][0], queries[i][1], pairs, pairValues, new HashSet<String>(), 1);
            res[i] = t==0? -1:t;
        }
        return res;
    }
    
    private double calcEquationDFS(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> pairValues, HashSet<String> visit, double cur) {
        if(visit.contains(start)) return 0;
        if(!pairs.containsKey(start)) return 0;
        if(start.equals(end)) return cur;
        visit.add(start);
        ArrayList<String> tStr=pairs.get(start);
        ArrayList<Double> tVal=pairValues.get(start);
        double res=0;
        for(int i=0;i<tStr.size();i++){
            res=calcEquationDFS(tStr.get(i), end, pairs, pairValues, visit, cur*tVal.get(i));
            if(res!=0) break;
        }
        visit.remove(start);
        return res;
    }
    */
    