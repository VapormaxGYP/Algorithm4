package Joseph_Ring;

import java.util.ArrayList;
import java.util.List;

/**
 * Joseph Ring : suppose that we have n people sitting around a table in a ring. Let the people report their number, every time,
 * when a person report m, we remove him out of the table, and the person after him starts from 1.
 */
public class JosephRing_ArrayList {
    public static int getLast(int n, int m)
    {
        List<Integer> last = new ArrayList<>();
        int position = 0;

        for(int i = 0; i < n; i++)
        {
            last.add(i);
        }

        while(n > 1)
        {
            position = (position + m - 1) % n;
            last.remove(position);
            n--;
        }

        return last.get(0);
    }

    public static void main(String[] args) {
        System.out.println(JosephRing_ArrayList.getLast(5,3));
    }
}
