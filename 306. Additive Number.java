    // 306. Additive Number
    
    public boolean isAdditiveNumber(String num) {
        for(int i = 1; i < num.length(); i++) {
            for(int j = i + 1; j < num.length(); j++) {
                if(validate(num, i, j)) 
                    return true;
                if(num.charAt(i) == '0') break;
            }
            if(num.charAt(0) == '0') break;
        }
        return false;
    }
    private boolean validate(String nums, int n1, int n2) {
        String temp = new String(nums);
        long pre1 = Long.valueOf(nums.substring(0, n1)), pre2 = Long.valueOf(nums.substring(n1, n2));
        temp = temp.substring(n2);
        while(temp.length() != 0) {
            String next = String.valueOf(pre1 + pre2);
            if(temp.startsWith(next)) {
                temp = temp.substring(next.length());
                pre1 = pre2;
                pre2 = Long.valueOf(next);
            }
            else 
                return false;
        }
        return true;
    }
    
    /*
    public boolean isAdditiveNumber(String num) {
        int length=num.length();
        for(int i=1;i<length;i++){
            if(num.charAt(0)=='0'&&i>1) return false;
            for(int j=i+1;length-j>=j-i&&length-j>=i;j++){
                if(num.charAt(i)=='0'&&j-i>1) break;
                long l=Long.parseLong(num.substring(0,i));
                long r=Long.parseLong(num.substring(i,j));
                if(isValid(num,j,l,r)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(String num, int start, long l, long r){
        if(start>=num.length()) return true;
        l=l+r;
        String t=Long.toString(l);
        if(!num.startsWith(t,start)) return false;
        return isValid(num,start+t.length(),r,l);
    }
    */