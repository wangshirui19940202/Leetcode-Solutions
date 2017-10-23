    // 318. Maximum Product of Word Lengths

    public int maxProduct(String[] words) {
        int[] list = new int[words.length];
        for (int i = 0; i < words.length; i ++) {
            int cur = 0;
            for (char c : words[i].toCharArray()) cur = cur | 1 << (c - 'a');
            list[i] = cur;
        }
        int res = 0;
        for (int i = 0; i < list.length; i++)
            for (int j = i + 1; j < list.length; j++)
                if ((list[i] & list[j]) == 0) res = Math.max(res, words[i].length() * words[j].length());
        return res;
    }
    