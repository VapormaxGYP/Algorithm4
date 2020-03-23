package Iteration_Algorithm;

/**
 * Euclid's Algorithm
 * 欧几里得算法
 * 找到两个数字的最大公约数
 * 自然语言描述：给出任意两个非负整数 p,q
 * 如果 q = 0 那么，最大公约数为p
 * 否则 将 p 除以 q 得到余数 r
 * p 和 q 的最大公约数即为 q 和 r 的最大公约数
 */

public class Euclid_Algorithm {
    public static int gcd(int p, int q)
    {
        if(p < 0 || q < 0)
            return -1;
        if(q == 0)
            return p;
        int r = p % q;

        return gcd(q,r);
    }

    public static int gcd2(int p, int q)
    {
        if(p < 0 || q < 0)
            return -1;
        return q == 0 ? p : gcd2(q, p%q);
    }
}
