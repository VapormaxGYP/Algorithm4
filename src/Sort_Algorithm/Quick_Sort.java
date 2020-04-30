package Sort_Algorithm;

@SuppressWarnings("unchecked")
public class Quick_Sort {
    public static void Sort(Comparable[] a)
    {
        Quick_Sort.shuffle(a);
        Sort(a, 0, a.length-1);

    }

    public static void Sort(Comparable[] a, int lo, int hi)
    {
        if(hi - lo <= 3)
        {
            Quick_Sort.Insertion_Sort(a,lo,hi);
            return;
        }
        int j = partition(a,lo,hi);
        Sort(a,lo,j-1);
        Sort(a,j+1,hi);
    }

    public static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while(true)
        {
            while(a[++i].compareTo(v) <= 0) if(i == hi) break;
            while(a[--j].compareTo(v) >= 0) if(j==lo) break;
            if(i >= j)
                break;
            Quick_Sort.Exchange(a, i, j);
        }

        Quick_Sort.Exchange(a, lo, j);

        return j;

    }

    /**
     * Sattolo_Algorithm: Use this to resort the elements so that we can get rid of the affect
     * caused by the element that we inputted
     */
    public static void shuffle(Comparable[] a)
    {
        int size = a.length-1;
        for(int i = size; i >= 0; i--)
        {
            int index = (int)Math.random()*size;
            Comparable temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }

    public static void Exchange(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void Insertion_Sort(Comparable[] a, int lo, int hi)
    {
        Comparable temp;
        int j;
        for(int i = lo+1; i <= hi; i++)
        {
            temp = a[i];
            for(j = i-1; j >= lo && (a[j].compareTo(temp) > 0); j--)
            {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }
}

class Quick_Sort_test
{
    public static void main(String[] args) {
        Comparable[] chars = {1,2,3,4,5,6};
        Quick_Sort.Sort(chars);
        for(int i = 0; i<chars.length; i++)
            System.out.print(chars[i]);

    }

}
