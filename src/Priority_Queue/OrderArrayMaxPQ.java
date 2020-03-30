package Priority_Queue;

import java.sql.SQLOutput;

public class OrderArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; // To store all elements
    private int n;    // The number of elements

    @SuppressWarnings("unchecked")
    public OrderArrayMaxPQ(int Capacity) // Use a constructor to initialize the class
    {
        pq = (Key[]) new Comparable[Capacity];
        n = 0;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    public Key delMax()
    {
        return pq[--n];
    }

    public void insert(Key key)
    {
        int i = n - 1;
        while(i >= 0 && less(key, pq[i]))
        {
            pq[i + 1] = pq[i];
            i--;
        }
        pq[i + 1] = key;
        n++;
    }

    private boolean less(Key a, Key b)
    {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        OrderArrayMaxPQ<String> pq = new OrderArrayMaxPQ<>(7);
        pq.insert("p");
        pq.insert("r");
        pq.insert("i");
        pq.insert("o");
        pq.insert("r");
        pq.insert("t");
        pq.insert("y");
        while(!pq.isEmpty())
            System.out.println(pq.delMax());
    }

}
