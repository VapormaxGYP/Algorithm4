package Sort_Algorithm;

/**
 * This Class is used to implement a new Merge Method, different from the first version (From top to down)
 * This Method is used to do the Merge sort from down to top;
 * This Method is suit for the List structure.
 * AEEEEGLMMOPRRSTX
 */

public class Merge_Sort_2 {
    private static Comparable[] array_cpy;

    public static void Sort(Comparable[] a)
    {
        int N = a.length;
        array_cpy = new Comparable[N];

        for(int sz = 1; sz < N; sz = sz+sz)
            for(int lo = 0; lo < N-sz; lo += sz+sz)
                Merge(a,lo,lo+sz-1, Math.min(lo+sz+sz-1,N-1));
    }

    public static void Merge(Comparable[] a, int lo, int mid, int hi)
    {
        int i = lo;
        int j = mid + 1;

        for(int k = lo; k <= hi; k++)
        {
            array_cpy[k] = a[k];
        }

        for(int k = lo; k <= hi; k++)
        {
            if(i > mid)
                a[k] = array_cpy[j++];
            else if(j > hi)
                a[k] = array_cpy[i++];
            else if(array_cpy[j].compareTo(array_cpy[i]) < 0)
                a[k] = array_cpy[j++];
            else
                a[k] = array_cpy[i++];
        }
    }
}
class Test2
{
    public static void main(String[] args) {
        Comparable[] chars = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};

        Merge_Sort_2.Sort(chars);

        for(int i = 0; i < chars.length; i++)
        {
            System.out.print(chars[i]);
        }

    }
}