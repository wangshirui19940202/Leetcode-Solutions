    // 475. Heaters

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for(int i : houses) {
            int index = Arrays.binarySearch(heaters, i);
            if(index < 0) 
                index = -(index + 1);
            else continue;
            int l = index == 0 ? Integer.MAX_VALUE : i - heaters[index - 1];
            int r = index == heaters.length ? Integer.MAX_VALUE : heaters[index] - i;
            res = Math.max(res, Math.min(l, r));
        }
        return res;
    }