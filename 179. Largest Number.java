    // 179. Largest Number
   
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < ss.length; i++) ss[i] = String.valueOf(nums[i]);
        Arrays.sort(ss, (a, b) -> ((b + a).compareTo(a + b)));
        if (ss[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        return sb.toString();
    }