package Sort_Algorithm;

public class Quick_Sort_3ways {

    public static void shuffle(Comparable[] a)
    {
        int size = a.length;
        int index = (int)Math.random()*size;
        for(int i = size; i >= 0; i--)
        {
            Quick_Sort_3ways.Exchange(a,i,index);
        }
    }

    public static void Sort(Comparable[] a)
    {
        //Quick_Sort_3ways.shuffle(a);
        Sort(a, 0, a.length - 1);
    }

    public static void Sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo)
            return;
        int lt = lo, i = lo+1, gt = hi; // Here we set 3 point, from lo to lt, lt to gt, gt+1 to hi

        Comparable v = a[lo];

        while(i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if(cmp < 0) Exchange(a, lt++, i++);
            else if(cmp > 0) Exchange(a, i, gt--);
            else i++;
        }
        Sort(a, lo,lt - 1);
        Sort(a, gt+1, hi);
    }

    public static void Exchange(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

class Quick_Sort_3Ways_test
{
    public static void main(String[] args) {
        Comparable[] chars = {3,2,1};
        Quick_Sort.Sort(chars);
        for(int i = 0; i<chars.length; i++)
            System.out.print(chars[i]);
    }

}