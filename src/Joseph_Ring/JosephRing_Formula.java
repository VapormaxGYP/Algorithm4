package Joseph_Ring;

/**
 * Consider the last man's position in the whole array: n = 5, m = 3
 * 0,1,2,3,4              3's position : 3
 * 3,4,0,1                3's position : 0
 * 1,3,4,1                3's position : 1
 * 1,3,1,3                3's position : 1
 * 3                      3's position : 0
 *
 * From the last line to the top line, we consider this:
 *
 * Each line's beginning element need to plus 3 so that it equals the position that show in upper line(if the upper line is
 * not enough long, suppose that it is a loop).
 *
 * According to this we can get that:
 * position = (position_in_Low_Line + m) % n(this line's length);
 */
public class JosephRing_Formula {
    public static int getLast(int n, int m)
    {
        int position = 0;
        for(int i = 1; i <= n; i++)  //here we can straightly set i = 2, cause any number % 1 = 0
        {                            //means that the last line is no need to consider.
            position = (position + m) % i;
        }

        return position;             //cause the array's number is equals to the position index so just return the position is OK
    }

    public static void main(String[] args) {
        System.out.println(getLast(5,3));
    }

}
