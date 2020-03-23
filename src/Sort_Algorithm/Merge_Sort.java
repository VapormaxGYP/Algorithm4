package Sort_Algorithm;

/**
 * This method aims at doing the sort works in original place
 * which is called in-place merge
 * Here is a Front-to-Down Merge Sort
 * if the Array has N elements it needs 1/2NlgN to NlgN times compare
 * The biggest times to visit the array is 6N*lgN times
 *
 * Method Sort is a method to sort from top to down which means we first sort the biggest part (left part and right part)
 * And then we sort smaller part until the whole array are sorted
 *
 */

public class Merge_Sort {
    private static Comparable[] array_cpy;
    private static Comparable[] array_cpy2;

    public static void Sort(Comparable[] a) {
        array_cpy = a.clone();

        Sort(array_cpy, a, 0, a.length - 1);
    }

    public static void Sort(Comparable[] a,Comparable[] array_cpy, int lo, int hi)
    {
        /**
         * Here we can do some change, to finished the Iteration
         * If we want to make our Merge sort more quick, we can change the end condition to other condition
         * such as, if the array's elements are less than 10, we use Insert Sort instead Merge sort
         */
        if(hi-lo>=5)
        {
            Insert_Sort(array_cpy,lo,hi);
            return;
        }
        int mid = lo+(hi-lo)/2;
        Sort(array_cpy, a, lo, mid);
        Sort(array_cpy, a,mid+1, hi);
        /**
         * Here we add a judge, if a[mid] is less than a[mid+1], Then we decide that the Array is already
         * be ordered.
         */
        if(a[mid].compareTo(a[mid+1]) < 0)
            return;
        inPlace_Merge(a, array_cpy, lo, mid, hi);
    }

    public static void inPlace_Merge(Comparable[] array,Comparable[] array_cpy, int lo, int mid, int hi)
    {
        /**
         * First step, we divided the array into two parts.
         */
        int i = lo;
        int j = mid+1;

        /**
         * Copy the chars[] into the array_cpy[]
         * To avoid using this time, we exchange the Source array: array and Destination array: array_cpy
         * every time when we use the Iteration. And inside the Merge.
         */

        for(int k = lo; k <= hi; k++)
        {
            if(i > mid)
                array_cpy[k] = array[j++];
            else if(j > hi)
                array_cpy[k] = array[i++];
            else if(array[j].compareTo(array[i])<0)
                array_cpy[k] = array[j++];
            else
                array_cpy[k] = array[i++];
        }
    }

    public static void Insert_Sort(Comparable[] a, int lo, int hi)
    {
        Comparable temp;
        int n;
        for(int m = lo+1; m <= hi; m++)
        {
            temp = a[m];
            for(n = m-1; n>=lo && (a[n].compareTo(temp)) > 0; n--)
                a[n+1] = a[n];
            a[n+1] = temp;
        }
    }

}

class Test
{
    public static void main(String[] args) {
        Comparable[] chars = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};

        for(int i = 0; i < chars.length; i++)
            System.out.print(chars[i]);

        Merge_Sort.Sort(chars);

        System.out.println();
        for(int i = 0; i < chars.length; i++)
            System.out.print(chars[i]);
    }
}
