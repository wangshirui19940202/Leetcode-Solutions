    // 42. Trapping Rain Water
    
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int res = 0, l = 0, r = height.length - 1, level = 0;
        while (l < r) {
            level = Math.min(height[l], height[r]);
            while (height[l] <= level && l < r)
                res += level - height[l++];
            while (height[r] <= level && l < r)
                res += level - height[r--];
        }
        return res;
    }
    
    
    /*
    // 前のとは同じ
    public int trap(int[] height) {
        int res=0,level=0;
        int l=0,r=height.length-1;
        while(l<r){
            int lh=height[height[l]<height[r]?l++:r--];
            level=Math.max(lh,level);
            res+=level-lh;
        }
        return res;
    }
    */