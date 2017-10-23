    // 241. Different Ways to Add Parentheses

    HashMap<String, List<Integer>> hash = new HashMap();
    public List<Integer> diffWaysToCompute(String input) {
        if (hash.containsKey(input)) return hash.get(input);
        List<Integer> res = new LinkedList();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '*' || cur == '-') {
                List<Integer> l = diffWaysToCompute(input.substring(0, i));
                List<Integer> r = diffWaysToCompute(input.substring(i + 1));
                for (int num1 : l)
                    for (int num2 : r ) {
                        switch (cur) {
                            case '+':
                                res.add(num1 + num2);
                                break;
                            case '-':
                                res.add(num1 - num2);
                                break;
                            case '*':
                                res.add(num1 * num2);
                                break;
                        }
                    }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        hash.put(input, res);
        return res;
    }
    
    /*
    public List<Integer> diffWaysToCompute(String input) {
        return backtrack(input, new HashMap<String, List<Integer>>());
    }
    
    private List<Integer> backtrack(String input, HashMap<String, List<Integer>> hash){
        if(hash.containsKey(input)) return hash.get(input);
        List<Integer> res = new LinkedList();
        for(int t = 0; t < input.length(); t++){
            if(input.charAt(t) == '+'||input.charAt(t) == '-'||input.charAt(t) == '*'){
                List<Integer> l = backtrack(input.substring(0, t), hash);
                List<Integer> r = backtrack(input.substring(t + 1), hash);
                for(int i: l)
                    for(int j: r){
                        switch(input.charAt(t)){
                            case '+':
                                res.add(i + j);
                                break;
                            case '-': 
                                res.add(i - j);
                                break;
                            case '*': 
                                res.add(i * j);
                                break;
                            default:
                        }
                    }
            } 
        }
        if(res.size() == 0) res.add(Integer.valueOf(input));
        hash.put(input, res);
        return res;
    } 
    */
    