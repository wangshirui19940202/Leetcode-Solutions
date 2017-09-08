// 17. Letter Combinations of a Phone Number
// Iterative solution, using Queue not backtrack

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length() == 0) return res;
        String[] dict = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] ss = digits.toCharArray();
        res.add("");
        for(int i = 0; i < digits.length(); i++){
            while(res.get(0).length() == i) {
                String cur = res.remove(0);
                for(char c: dict[ss[i] - '0'].toCharArray()) {
                    res.add(cur + c);
                }
            }
        }
        return res;
    }