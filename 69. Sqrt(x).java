    // 69. Sqrt(x)
    
    public int mySqrt(int x) {
        if(x < 2) return x;
        int l = 0, r = x;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(mid > x / mid)
                r = mid - 1;
            else {
                if((mid + 1) > x / (mid + 1))
                    return mid;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }
    