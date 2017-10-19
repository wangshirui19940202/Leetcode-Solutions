    // 50. Pow(x, n)

    /*
        pow (x, 11) = x * pow(x ^ 2, 5) 
                    = x * x ^ 2 * pow(x ^ 4, 2)
                    = x * x ^ 2 * pow(x ^ 8 ,1)
    */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n++;
                res = 1 / x;
            }
            n = -n;
            x = 1 / x;
        }
        while (n > 1) {
            if (n % 2 == 1) res *= x; 
            x = x * x;
            n /= 2;
        }
        return res * x;
    }

    /*
    // faster
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n ++;
                return 1 / x * myPow(1 / x, -n);
            }
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            double half = myPow(x, n / 2);
            return half * half;
        } else {
            double half = myPow(x, n / 2);
            return half * half * x;
        }
    }
    */
    
    /*
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){ 
            if( n == Integer.MIN_VALUE)
            {
                ++n;
                n = -n;
                x = 1/x;
                return x * x * myPow( x*x, n/2 );
            }
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
    */