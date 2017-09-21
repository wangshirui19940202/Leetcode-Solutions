    // 299. Bulls and Cows
    
    public String getHint(String secret, String guess) {
        int[] hash = new int[255];
        char[] ss = secret.toCharArray(), gs = guess.toCharArray();

        int A = 0, B = 0;
        for(int i = 0; i < ss.length; i++) {
            if(gs[i] == ss[i])
                A++;
            else
                hash[ss[i]]++;
        }
        for(int i = 0; i < gs.length; i++) {
            if(ss[i] != gs[i] && --hash[gs[i]] >= 0)
                B++;
        }
        return A + "A" + B + "B";
    }