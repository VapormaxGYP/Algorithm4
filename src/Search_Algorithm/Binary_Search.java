package Search_Algorithm;

public class Binary_Search<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;

    private int N = 0;

    @SuppressWarnings("unchecked")
    public Binary_Search(int Capacity)
    {
        keys = (Key[]) new Comparable[Capacity];
        values = (Value[]) new Object[Capacity];
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    /**
     * Find the min and Max key
     * @return
     */
    public Key min()
    {
        if(isEmpty()) return null;

        return keys[0];
    }

    public Key max()
    {
        if(isEmpty()) return null;

        return keys[N - 1];
    }

    public Value get(Key key)
    {
        if(isEmpty()) return null;

        int i = rank(key);
        if(i < N && key.compareTo(keys[i]) == 0)
            return values[i];
        else
            return null;
    }

    public boolean contains(Key key)
    {
        if(isEmpty()) return false;

        return get(key) == null;
    }

    public void put(Key key, Value value)
    {
        if(value == null)
        {
            delete(key);
            return;
        }

        int i = rank(key);

        if(i < N && key.compareTo(keys[i]) == 0)
        {
            values[i] = value;
            return;
        }
        else
        {   //找不到的话全体后移一位，把 i 位置插入待更新元素, 容量 +1
            for(int j = N; j > i; j--)
            {
                keys[j] = keys[j - 1];
                values[j] = values[j - 1];
            }
            keys[i] = key;
            values[i] = value;

            N++;
        }

    }

    public void delete(Key key)
    {
        if(isEmpty()) return;

        if(key == null) return;

        int i = rank(key);
        if(i == N && key.compareTo(keys[i]) != 0) return;

        for(int j = i; j < N; j++)
        {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        N--;

        keys[N] = null;
        values[N] = null;
    }

    public Key ceiling(Key key)
    {
        if(key == null) return null;

        int i = rank(key);
        if(i == N) return null;
        else return keys[i];
    }

    public Key floor(Key key)
    {
        if(key == null) return null;

        int i = rank(key);
        if(i < N && key.compareTo(keys[i]) == 0) return keys[i];
        if(i == 0) return null;
        else return keys[i - 1];
    }

    public int rank(Key key)
    {
        int lo = 0, hi = N - 1;

        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if(cmp < 0) lo = mid + 1;
            else if(cmp > 0) hi = mid - 1;
            else return mid;
        }

        return lo;
    }
}
