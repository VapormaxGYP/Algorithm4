package Search_Algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class SeparateChainingHashST<Key, Value> {

    private int N;                                 // 键值对的总数
    private int M;                                 // 散列表的大小

    private SequentialSearchST<Key, Value>[] st;   // 存放链表对象的数组
    private static final int INIT_CAPACITY = 4;

    public SeparateChainingHashST(int M)
    {
        this.M = M;

        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];

        for(int i = 0; i < M; i++)
        {
            st[i] = new SequentialSearchST();
        }
    }
    public SeparateChainingHashST()
    {
        this(INIT_CAPACITY);
    }

    public void resize(int chains)
    {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(chains);
        for(int i = 0; i < M; i++)
        {
            for(Key key : st[i].keys())
            {
                temp.put(key, st[i].get(key));
            }
        }
        this.M = temp.M;
        this.N = temp.N;
        this.st = temp.st;
    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return (size() == 0);
    }

    public boolean contains(Key key)
    {
        if(key == null) return false;
        return get(key) != null;
    }

    public Value get(Key key)
    {
        if(key == null) return null;
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value value)
    {
        if(key == null) return;
        if(value == null)
        {
            delete(key);
            return;
        }
        if (N >= 10*M) resize(2*M);

        int i = hash(key);
        if (!st[i].contains(key)) N++;
        st[i].put(key, value);
    }

    public void delete(Key key)
    {
        if(key == null) return;

        int i = hash(key);
        if(st[i].contains(key)) N--;
        st[i].delete(key);

        if(M > INIT_CAPACITY && N <= 2 * M) resize(M/2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.offer(key);
        }
        return queue;
    }
}
