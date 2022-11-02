package _50_Pow_x_n_;

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
        Example 1:
        Input: x = 2.00000, n = 10
        Output: 1024.00000

        Example 2:
        Input: x = 2.10000, n = 3
        Output: 9.26100

        Example 3:
        Input: x = 2.00000, n = -2
        Output: 0.25000
        Explanation: 2-2 = 1/22 = 1/4 = 0.25
*/
public class Solution {
    public double myPow(double x, int n) {
        if (n >= 0)
            return myIml2(x, n);
        else {
            return 1.0 / myIml2(x, -(long) n);
        }

    }

    private double myIml(double x, long n) {
        if (n == 0)
            return 1.0;
        double append = n % 2 == 1 ? x : 1;
        return myIml(x * x, n / 2) * append;
    }

    public double myIml2(double x, long n) {
        double iter = x;
        double res = 1.0;
        while (n > 0) {
            if (n % 2 == 1)
                res *= iter;
            iter *= iter;
            n /= 2;
        }
        return res;
    }
}
