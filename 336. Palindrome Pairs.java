    // 336. Palindrome Pairs

    public List<List<Integer>> palindromePairs(String[] words) {
        LinkedList<List<Integer>> res = new LinkedList();
        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        for(int i = 0; i < words.length; i++) {
            String cur = words[i];
            for(int j = 0; j <= cur.length(); j++) {
                String str1 = cur.substring(0, j), str2 = cur.substring(j, cur.length());
                if(check(str1)) {
                    String required = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(required) && map.get(required) != i) {
                        LinkedList<Integer> list = new LinkedList();
                        list.add(map.get(required));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(!str2.equals("") && check(str2)) {
                    String required = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(required) && map.get(required) != i) {
                        LinkedList<Integer> list = new LinkedList();
                        list.add(i);
                        list.add(map.get(required));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    private boolean check(String input) {
        char[] ss = input.toCharArray();
        int l = 0, r = input.length() - 1;
        while(l < r && ss[l] == ss[r]) {
            l++;
            r--;
        }
        return l >= r;
    }
    