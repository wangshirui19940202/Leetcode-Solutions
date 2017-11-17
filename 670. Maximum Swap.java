    // 670. Maximum Swap

    public int maximumSwap(int num) {
        char[] ss = new String(num + "").toCharArray();
        int[] bucket = new int[10];
        for (int i = 0; i < ss.length; i++) bucket[ss[i] - '0'] = i;
        
        for (int i = 0; i < ss.length; i++) {
            for (int c = 9; c > ss[i] - '0'; c--)
                if (bucket[c] > i) {
                    ss[bucket[c]] = ss[i];
                    ss[i] = (char)(c + '0');
                    return Integer.valueOf(new String(ss));
                }
        }
        return num;
    }