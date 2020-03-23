package Sort_Algorithm;

/**
 * choose the second element of the array, and then compare with every element before it,
 * if they are bigger than the element change them
 */
public class Insertion_Sort {
    public static void main(String[] args) {
        Insertion_Sort insertion_sort = new Insertion_Sort();
        Comparable[] chars = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};
        insertion_sort.Sort(chars);
        insertion_sort.Sort_Without_Exchange(chars);
    }

    public void Sort(Comparable[] array)
    {
        Comparable temp;
        int size = array.length;
        for(int i = 1; i < size; i++)
        {
            for(int j = i; j >=1 && (array[j].compareTo(array[j-1]) < 0); j--)
            {
                temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
            }
        }
        for(int z = 0; z<size;z++)
            System.out.print(array[z]);
    }

    /**
     * Here we just need to visit the array once, not twice as the exchange method
     */
    public void Sort_Without_Exchange(Comparable[] array)
    {
        Comparable temp;
        int size = array.length;
        for(int i = 1; i < size; i++)
        {
            temp = array[i];
            int j;
            for( j = i-1; j >= 0 &&(array[j].compareTo(temp)) > 0; j--) {
                array[j+1] = array[j];
                //every element in the array move to it's next position and the position where temp is not less than array[j]
                //does not have a new element, so we just add the temp to the new position and all the things are ok.
            }
            /**
             * here we use array[j+1] is because we need to store the element into array[j] but
             * in the loop up, j--, so we need to add back, that is the real j
             */
            array[j+1] = temp;
        }
        System.out.println();
        for(int z = 0; z<size;z++)
            System.out.print(array[z]);
    }
}
