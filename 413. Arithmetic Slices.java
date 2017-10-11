    // 413. Arithmetic Slices
    
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0, cur = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
                res =+ ++cur;
            else cur = 0;
        }
        return res;
    }