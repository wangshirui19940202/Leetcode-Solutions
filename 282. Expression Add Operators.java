    // 282. Expression Add Operators
    
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList();
        char[] nums = num.toCharArray();
        for(int i = 1; i <= nums.length; i++) {
            Long temp = Long.valueOf(new String(nums, 0, i));
            backtrack(res, nums, i, target - temp, String.valueOf(temp) + "", temp);
            if(nums[0] == '0') break;
        }
        return res;
    }
    //using int lastnum is faster than long lastnum
    private void backtrack(List<String> res, char[] nums, int cur, long target, String curstr, long lastnum) {
        if(cur == nums.length && target == 0) {
            res.add(curstr);
            return;
        }
        for(int i = cur + 1; i <= nums.length; i++) {
            Long temp = Long.valueOf(new String(nums, cur, i - cur));
            backtrack(res, nums, i, target - temp, curstr + "+" + temp, temp);
            backtrack(res, nums, i, target + temp, curstr + "-" + temp, 0 - temp);
            backtrack(res, nums, i, target + lastnum - temp * lastnum, curstr + "*" + temp, temp * lastnum);
            if(nums[cur] == '0') return;
        }
    }
    