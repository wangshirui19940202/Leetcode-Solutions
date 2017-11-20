    // 43. Multiply Strings

    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        char[] ss1 = num1.toCharArray(), ss2 = num2.toCharArray();
        for (int i = 0; i < ss1.length; i++) {
            for (int j = 0; j < ss2.length; j++) {
                int mul = (ss1[ss1.length - 1 - i] - '0') * (ss2[ss2.length - 1 - j] - '0');
                int sum = mul + res[i + j];
                res[i + j] = sum % 10;
                res[i + j + 1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = res.length - 1;
        for (; start > 0 && res[start] == 0; start--) ;
        for (; start >= 0; start --)
            sb.append(res[start]);
        return sb.toString();
    }