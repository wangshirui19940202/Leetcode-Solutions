    // 373. Find K Pairs with Smallest Sums

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) return new LinkedList();
        List<int[]> res = new LinkedList();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < nums1.length; i++)
            pq.add(new int[]{nums1[i] + nums2[0], nums1[i], 0});
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] cur = pq.remove();
            res.add (new int[]{cur[1], nums2[cur[2]]});
            if (cur[2] != nums2.length - 1)
                pq.add(new int[]{cur[1] + nums2[cur[2] + 1], cur[1], cur[2] + 1});
        }
        return res;
    }