package Sattolo_Algorithm;

/**
 * Sattolo Algorithm is used to make an ordered list into an unordered list
 */
public class Sattolo_Algorithm {
    private Sattolo_Algorithm(){}

    public static void cycle(Object[] a)
    {
        int size = a.length-1;

        for(int i = size; i>=0;i--)
        {
            double x = Math.random()*size;
            int r = (int)(x);
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5};
        cycle(a);
        for(int i = 0;i<a.length;i++)
            System.out.println(a[i]);
    }
}