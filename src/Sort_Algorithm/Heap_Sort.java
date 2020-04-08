package Sort_Algorithm;

import java.security.Key;

public class Heap_Sort {

    public static void Sort(Comparable[] a)
    {
        /**
         * First, we generate a Heap,which it's Largest element is stored in the top of the heap
         * Second, we use the sort method, change the largest with the lowest and then sink the heap top
         * Start form the half position of the Array, this is because After that, the heap are all children heap
         * which contains 1 element.
         *
         * 2 choice: from the left, to the end of the array, use Swim() to make the heap
         *           from the right, to the middle position of the array, use Sink() to make the heap
         *
         */
        int N = a.length;
        for(int k = N/2; k >= 1; k--)
            sink(a,k,N);
        while(N > 1)
        {
            Exchange(a,1, N--);
            sink(a,1, N);
        }
    }

    public static void sink(Comparable[] a, int k, int N)
    {
        while(2*k <= N)
        {
            int j = 2*k;
            if(j < N && less(a, j, j+1)) j++;
            if(!less(a, k, j)) break;
            Exchange(a, k, j);
            k = j;
        }
    }

    public static boolean less(Comparable[] a, int i, int j)
    {
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    public static void Exchange(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }

    public static void Swim(Comparable[] a, int k)
    {
        while(k > 1 && less(a, k/2, k))
        {
            Exchange(a, k, k/2);
            k = k/2;
        }
    }
}

class HeapSort_Test
{
    public static void main(String[] args) {
        Comparable[] chars = {'S','O','R','T','E','X','A','M','P','L','E'};
        Comparable[] nums = {5,4,3,2,1};
        Heap_Sort.Sort(chars);
        Heap_Sort.Sort(nums);
        for(Comparable a: chars)
            System.out.print(a);
        System.out.println();
        for(Comparable a: nums)
            System.out.print(a);
    }
}
