    // 273. Integer to English Words
    // Recursion
    // Attention on "Zero"
    
    String[] moreThanHundred = new String[]{"Hundred", "Thousand", "Million", "Billion"}; //1 000 , 1 000 000 , 1 000 000 000
    String[] lessThanTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tenth = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] moreThanTen = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return helper(num);
    }
    
    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if(num >= 1000000000) return sb.append(lessThanTen[num / 1000000000] + " " + moreThanHundred[3] + " "  + helper(num % 1000000000)).toString().trim();
        if(num >= 1000000) return sb.append(helper(num / 1000000) + " "  + moreThanHundred[2] + " "  + helper(num % 1000000)).toString().trim();
        if(num >= 1000) return sb.append(helper(num / 1000) + " "  + moreThanHundred[1] + " "  + helper(num % 1000)).toString().trim();
        if(num >= 100) return sb.append(lessThanTen[num / 100] + " "  + moreThanHundred[0] + " "  + helper(num % 100)).toString().trim();
        if(num >= 20) return sb.append(tenth[num / 10] + " "  + lessThanTen[num % 10]).toString().trim();
        if(num >= 10) return sb.append(moreThanTen[num - 10]).toString().trim();
        if(num < 10) return sb.append(lessThanTen[num]).toString().trim();
        return "";
    }