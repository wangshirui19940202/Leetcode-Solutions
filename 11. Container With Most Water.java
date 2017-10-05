    // 11. Container With Most Water
    
    public int maxArea(int[] height) {
        int res = 0, l = 0, r = height.length - 1, h = 0;
        while (l < r) {
            h = Math.min(height[l], height[r]);
            res = Math.max(res, h * (r - l));
            while (l < r && h >= height[l]) l++;
            while (l < r && h >= height[r]) r--;
        }
        return res;
    }
    