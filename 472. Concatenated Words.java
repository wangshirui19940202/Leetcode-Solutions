    // 472. Concatenated Words
    // function form: the same as "word break"
    // HashSet dict: only contains string that are shorter than String target

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new LinkedList();
        HashSet<String> dict = new HashSet();
        Arrays.sort(words, (a, b) -> {return a.length() - b.length();});
        for (int i = 1; i < words.length; i++) {
            dict.add(words[i - 1]);
            if (form(words[i], dict))
                res.add(words[i]);
        }
        return res;
    }
    private boolean form(String target, HashSet<String> dict) {
        if(target.length() == 0) return true;
        boolean[] dp = new boolean[target.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= target.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(target.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[target.length()];
    }
    