    // 517. Super Washing Machines

    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int i : machines) sum += i;
        if (sum % machines.length != 0) return -1;
        int ave = sum / machines.length;
        int res = 0, dif = 0;
        for (int i : machines) {
            dif += ave - i;
            res = Math.max (Math.max (res, Math.abs(dif)), i - ave);
        }
        return res;
    }
