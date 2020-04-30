package Search_Algorithm;

/**
 * 1. 任何一个节点不可能与两个红链接相连
 * 2. 所有的红链接都是左链接
 * 3. 树是 完美黑色平衡：任意空链接到根节点路径上的 黑链接数量 相同
 *
 * @param <Key>
 * @param <Value>
 */
public class Black_Red_BST <Key extends Comparable<Key>, Value> {

    /**
     * Define the true as red link and the false as black link
     */
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * The Node of the Black-Red BST
     */
    private class Node
    {
        Key key;                // 键
        Value value;            // 相关联的值
        Node left, right;       // 左右子树
        int N;                  // 节点总数
        boolean color;          // 由其 父节点 指向它的 链接 的颜色

        Node(Key key, Value value, int N, boolean color)
        {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private Node root;

    /**
     * Whether the tree contains the Key
     * and get the value of a specific key
     */
    public Value get(Key key)
    {
        return get(root, key);
    }
    public Value get(Node x, Key key)
    {
        int cmp = 0;

        while(x != null)
        {
            cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            if(cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }
    public boolean Contains(Key key)
    {
        return get(key) == null;
    }

    /**
     * The size of the tree
     */
    public int size(Node x)
    {
        if(x == null) return 0;
        return x.N;
    }

    /**
     * Test the Link's color(Father to it)
     */
    private boolean isRed(Node x)
    {
        if(x == null) return false;

        return x.color == RED;
    }

    /**
     * 左旋转
     * 右红链接 --> 左红链接
     * 红链接相连的两个节点
     *
     * 右旋转
     * 左红链接 --> 右红链接
     * 红链接相连两个节点
     */

    public Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);

        return x;
    }

    public Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);

        return x;
    }

    /**
     * The method used to insert into the tree.
     */

}
