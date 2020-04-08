package Iteration_Algorithm;

/**
 * Use the root of the tangent line's root to find a Curve's root
 *
 */

public class Newton_Iteration {

    public static double sqrt(double c)
    {
        if(c < 0)
            return Double.NaN;

        double err = 1e-15;
        double t = c;

        while((t-c/t) > 2 * err) //X𝑛₊₁ - X𝑛 < err jump out the loop, and get the answer X𝑛.
            t = (t + c/t) / 2.0;
        return t;
    }

    public static void main(String[] args) {
        System.out.println(Newton_Iteration.sqrt(1000));
    }

}
