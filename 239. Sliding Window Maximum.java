    // 239. Sliding Window Maximum

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        int n = nums.length, resindex = 0;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && i - dq.getFirst() + 1 > k) {
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
            if(i >= k - 1)
                res[resindex++] = nums[dq.getFirst()];
        }
        return res;
    }
    