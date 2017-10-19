    // 480. Sliding Window Median
    // when k is odd: lpq.size = rpq.size + 1
    // when k is even: lpq.size == rpq.size

    PriorityQueue<Integer> lpq = new PriorityQueue<Integer>((a, b) -> (b.compareTo(a)));
    PriorityQueue<Integer> rpq = new PriorityQueue<Integer>();
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                res[i - k] = getMid();
                remove(nums[i - k]);
            }
            if (i != nums.length)
                add(nums[i]);
        }
        return res;
    }
    
    private void add(int num) {
        double mid = getMid();
        if (mid >= num) {
            lpq.add(num);
            if (rpq.size() + 1 < lpq.size())
                rpq.add(lpq.poll());
        } else { 
            rpq.add(num);
            if (rpq.size() > lpq.size())
                lpq.add(rpq.poll());
        }
    }
    private void remove(int num) {
        double mid = getMid();
        if (mid >= num) {
            lpq.remove(num);
            if (rpq.size() > lpq.size())
                lpq.add(rpq.poll());
        } else { 
            rpq.remove(num);
            if (rpq.size() + 1 < lpq.size())
                rpq.add(lpq.poll());
        }
    }
    private double getMid() {
        if (lpq.isEmpty()) return 0;
        if (lpq.size() == rpq.size()) 
            return ((double)lpq.peek() + (double)rpq.peek()) / 2.0;
        else 
            return (double)lpq.peek();
    }