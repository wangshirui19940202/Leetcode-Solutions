    // 67. Add Binary

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] as = a.toCharArray(), bs = b.toCharArray();
        int ia = a.length() - 1, ib = b.length() - 1, c = 0;
        
        while(ia >= 0 || ib >= 0 || c != 0) {
            String next = "";
            int count = c;
            if(ia >= 0 && as[ia--] == '1') count++;
            if(ib >= 0 && bs[ib--] == '1') count++;
            if(count == 0 || count ==2) next = "0";
            else next = "1";
            c = count >= 2 ? 1 : 0;
            sb.append(next);  
        }
        
        return sb.reverse().toString();
    }