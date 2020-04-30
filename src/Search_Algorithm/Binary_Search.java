package Search_Algorithm;

/**
 * Define a key - value pair, to store the information
 * Using binary-Search to finish some operations
 * @param <Key>
 * @param <Value>
 */
public class Binary_Search<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;

    private int N = 0;

    /**
     * Initialize the class, including initialize the keys and values
     * @param Capacity
     */
    @SuppressWarnings("unchecked")
    public Binary_Search(int Capacity)
    {
        keys = (Key[]) new Comparable[Capacity];
        values = (Value[]) new Object[Capacity];
    }

    /**
     * get the size of the table
     * @return
     */
    public int size()
    {
        return N;
    }

    /**
     * To check whether the table is empty
     * @return
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    /**
     * Find the min and Max key in the table
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

    /**
     * Get the value of the specific key
     * @param key
     * @return
     */
    public Value get(Key key)
    {
        if(isEmpty()) return null;

        int i = rank(key);
        if(i < N && key.compareTo(keys[i]) == 0)
            return values[i];
        else
            return null;
    }

    /**
     * To check whether the table contains the key
     *
     * @param key
     * @return
     */
    public boolean contains(Key key)
    {
        if(isEmpty()) return false;

        return get(key) == null;
    }

    /**
     * Insert a key - value pair into the table.
     *
     * @param key
     * @param value
     */
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
        {   //找不到的话全体后移一位，把 i 位置插入待更新元素, 容量 +1 数组要先进行扩容
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

    /**
     * delete the element according to its key
     *
     * @param key
     */

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

    /**
     * ceiling means the smallest key that is greater than or equal to the given key
     *
     * @param key
     * @return
     */

    public Key ceiling(Key key)
    {
        if(key == null) return null;

        int i = rank(key);
        if(i == N) return null;
        else return keys[i];
    }

    /**
     * flooring means the largest key that is less than or equal to the current key
     *
     * @param key
     * @return
     */

    public Key floor(Key key)
    {
        if(key == null) return null;

        int i = rank(key);
        if(i < N && key.compareTo(keys[i]) == 0) return keys[i];
        if(i == 0) return null;
        else return keys[i - 1];
    }

    /**
     * rank the whole table by using Binary-Search way.
     *
     * @param key
     * @return
     */

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
