package Joseph_Ring;

public class JosephRing_Iteration {
    public static int getLast(int n, int m)
    {
        return F(n, m);
    }

    private static int F(int n, int m)
    {
        if(n == 1)
            return 0; //the end condition is when there are only 1 element left
        int position = F(n-1, m);
        return (position + m) % n;
    }

    public static void main(String[] args) {
        System.out.println(JosephRing_Iteration.getLast(5, 3));
    }
}
