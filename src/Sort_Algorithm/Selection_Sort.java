package Sort_Algorithm;

/**
 * choose the Min value of the array
 * change the position with the first element
 */
public class Selection_Sort {

    public static void main(String[] args) {

        Comparable[] chars = {'s','o','r','t'};

        Sort(chars);
    }

    public static <T extends Comparable<T>>void Sort(Comparable[] array)
    {
        Comparable t;
        for(int i = 0; i < array.length; i++)
        {
            int min = i;
            for(int j = i+1; j < array.length; j++ )
            {
                if(array[min].compareTo(array[j]) > 0)
                    min = j;
            }
            t = array[i];
            array[i] = array[min];
            array[min] = t;

            System.out.print(array[i]);
        }
    }
}
