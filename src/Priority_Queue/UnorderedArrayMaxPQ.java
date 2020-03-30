package Priority_Queue;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    @SuppressWarnings("unchecked")
    public UnorderedArrayMaxPQ(int Capacity)
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

    public void insert(Key key)
    {
        pq[n++] = key;
    }

    public Key delMax()
    {
        int max = 0;
        for(int i = 1; i < n; i++)
        {
            if(less(max,i))
                max = i;
        }
        Exchange(max, n - 1);
        return pq[--n];
    }

    private boolean less(int a, int b)
    {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void Exchange(int i, int j)
    {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<>(7);

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
