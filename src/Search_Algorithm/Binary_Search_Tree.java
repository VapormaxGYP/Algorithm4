package Search_Algorithm;

/**
 * Binary search Tree provide a 2lgN search
 * and a 2lgN insert.
 * The time that BST used depends on the shape of the tree
 *
 * @param <Key>
 * @param <Value>
 */
public class Binary_Search_Tree <Key extends Comparable<Key>, Value>{

    /**
     * Define the Node in the tree
     */

    private class Node {
        private Key key;                //键
        private Value value;            //值

        private Node left, right;       //左右指针
        private int size;               //节点总数

        public Node(Key key, Value val, int size)
        {
            this.key = key;
            this.value = val;
            this.size = size;
        }
    }

    private Node root;

    /**
     * Calculate size
     */

    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.size;
    }

    /**
     * Empty check
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    /**
     * Contains key?
     */
    public boolean containKey(Key key)
    {
        return false;
    }

    /**
     * return the value associated with key
     */
    public Value getKey(Key key)
    {
        return getKey(root,key);
    }

    private Value getKey(Node x, Key key)
    {
        if(x == null) return null;
        if(key == null) throw new IllegalArgumentException("The key is null");

        int cmp = key.compareTo(x.key);
        if(cmp < 0) return getKey(x.left, key);
        else if(cmp > 0) return getKey(x.right, key);
        else
            return x.value;
    }

    /**
     * Insert the node if the BST do not have
     * Renew the value if the BST have
     */

    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }
    private Node put(Node x, Key key, Value value)
    {
        if(x == null)  return new Node(key, value, 1);

        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, value);
        else if(cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;

        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * Find the least key in the BST
     */

    public Key min()
    {
        return min(root).key;
    }
    private Node min(Node x)
    {
        if(x.left == null) return x;

        return min(x.left);
    }


    /**
     * Find the largest key in the BST
     */

    public Key max()
    {
        return max(root).key;
    }
    private Node max(Node x)
    {
        if(x.right == null) return x;

        return max(x.right);
    }

    /**
     * Floor(the biggest number which is smaller than the key
     */
    public Key floor(Key key)
    {
        Node x = floor(root, key);
        return x.key;
    }
    private Node floor(Node x, Key key)
    {
        if(x == null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t != null) return t;
        else return x;
    }

    /**
     * Ceiling (the smallest number which is bigger than the key
     */
    public Key ceiling(Key key)
    {
        Node x = ceiling(root, key);
        return x.key;
    }
    private Node ceiling(Node x, Key key)
    {
        if(x == null) return null;

        int cmp = key.compareTo(x.key);

        if(cmp == 0) return x;
        if(cmp > 0) return ceiling(x.right, key);

        Node t = ceiling(x.left, key);
        if(t != null) return t;
        else return x;
    }

    /**
     * Select the key
     * if we want to find the rank k key. If the left tree has K and more than k then select in the left tree
     * if the left tree is less than k, then we select from the right tree begin with: k - size(left) - 1
     */
    public Key select(int k)
    {
        return select(root, k).key;
    }
    private Node select(Node x, int k)
    {
        if(x == null) return null;

        int t = size(x.left);
        if(t > k) return select(x.left, k);
        else if(t < k) return select(x.right, t - k - 1);
        else return x;
    }

    /**
     * Rank() is the reverse method of select
     * rank() returns the rank of the key
     * if key == root.key return size(left)
     * if key < root.key return size(x.left)
     * if key > root.key return 1 + size(x.left) + rank(key, x.right)
     */
    public int rank(Key key)
    {
        return rank(root, key);
    }
    private int rank(Node x, Key key)
    {
        if(x == null) return 0;

        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(x.left, key);
        else if(cmp > 0) return (1 + size(x.left) + rank(x.right, key));
        else return size(x.left);
    }

    /**
     * Delete the Minimum number in the tree
     */
    public void deleteMin()
    {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x)
    {
        if(x.left == null) return x.right;

        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * Delete the Maximum number in the tree
     */
    public void deleteMax()
    {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x)
    {
        if(x.right == null) return x.left;

        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * Delete Any node in the tree
     */
    public void delete(Key key)
    {
        root = delete(root, key);
    }
    private Node delete(Node x, Key key)
    {
        if(x == null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, key);
        else if(cmp > 0) x.right = delete(x.right, key);
        else
        {
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;

            Node t = x; // Record the node, search for its next node

            x = min(t.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }

        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

}
