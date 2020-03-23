package Sort_Algorithm;

/**
 * Each element whose distance is h are sorted
 * Using Insertion Sort to finish
 */
public class Shell_Sort {
    public static void main(String[] args) {
        Comparable[] chars = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};
        Shell_Sort shell_sort = new Shell_Sort();
        shell_sort.Sort(chars);
        shell_sort.Sort_Without_Exchange(chars);
    }

    public void Sort(Comparable[] array)
    {
        int size = array.length;
        int h = 1; //set the distance 1

        while(h<size/3) h = 3*h+1; //1,4,13,40...
        while(h>0)
        {
            for(int i = h; i < size; i++)
            {
                Comparable temp;
                //System.out.println("i = " + i);
                for(int j = i; j>=h && (array[j].compareTo(array[j-h])<0); j-=h)
                {
                    //System.out.println("j = " + j);
                    temp = array[j-h];
                    array[j-h] = array[j];
                    array[j] = temp;
                }
            }
            h/=3;
        }
        for (Comparable comparable : array) System.out.print(comparable);
    }

    public void Sort_Without_Exchange(Comparable[] array)
    {
        int size = array.length;
        int h = 1;
        while(h<size/2) h = 2*h+1;

        while(h>0)
        {
            for(int i = h; i < size; i++)
            {
                Comparable temp = array[i];
                int j;
                for(j = i-h; j>=0 &&(array[j].compareTo(temp)>0); j-=h)
                {
                    array[j+h] = array[j];
                }
                array[j+h] = temp;
            }
            h/=2;
        }
        System.out.println();
        for (Comparable comparable : array) System.out.print(comparable);
    }
}
