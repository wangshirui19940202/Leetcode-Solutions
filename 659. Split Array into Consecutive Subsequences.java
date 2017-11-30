class Solution {
    // 659. Split Array into Consecutive Subsequences

    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;
        int prenum = Integer.MIN_VALUE, pre1 = 0, pre2 = 0, pre3 = 0;
        int curnum = nums[0], cur1 = 0, cur2 = 0, cur3 = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
                count++;
            }
            prenum = curnum;
            pre1 = cur1;
            pre2 = cur2;
            pre3 = cur3;
            
            curnum = nums[i];
            if (curnum == prenum + 1) {
                if (count < pre1 + pre2) return false;
                cur1 = Math.max(count - pre1 - pre2 - pre3, 0);
                cur2 = pre1;
                cur3 = pre2 + Math.min(pre3, count - pre2 - pre1);
            } else {
                if (pre1 != 0 || pre2 != 0) return false;
                cur1 = count;
                cur3 = 0;
            }
        }
        return cur1 == 0 && cur2 == 0;
    }
}