/**
 * Class for tst.
 *
 * @param      <Value>  The value
 */
public class TST<Value> {
    /**
     * size.
     */
    private int n;
    /**
     * root of TST.
     */
    private Node<Value> root;
    /**
     * Class for node.
     *
     * @param      <Value>  The value
     */
    private static class Node<Value> {
        /**
         * c.
         */
        private char c;
        /**
         * left, middle, and right subtries.
         */
        private Node<Value> left, mid, right;
        /**
         * value associated with string.
         */
        private Value val;
    }

    /**
     * Initializes an empty string symbol table.
     * time complexity - L+logN.
     */
    public TST() {
    }
    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     *
     * Complexity is 1.
     */
    public boolean contains(final String key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the given key
     * if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     *
     * Complexity is l + log N.
     *
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final String key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls get() with null argument");
        }
        if (key.length() == 0) {
            throw new IllegalArgumentException("key must have length >= 1");
        }
        Node<Value> x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }
    /**
     * get.
     *
     * Complexity is L.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      d     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node<Value> get(final Node<Value> x,
        final String key, final int d) {
        if (x == null) {
            return null;
        }
        if (key.length() == 0) {
            throw new IllegalArgumentException(
                "key must have length >= 1");
        }
        char c = key.charAt(d);
        if      (c < x.c) {
            return get(x.left,  key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid,   key, d + 1);
        } else {
            return x;
        }
    }
    /**
     * Inserts the key-value pair into the symbol table, overwriting
     * the old value
     * with the new value if the key is already in the symbol table.
     * If the value is {@code null}, this effectively deletes the key
     * from the symbol table.
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final String key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls put() with null key");
        }
        if (!contains(key)) {
            n++;
        }
        root = put(root, key, val, 0);
    }
    /**
     * put.
     *
     * Complexity is L.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     * @param      d     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node<Value> put(final Node<Value> x, final String key,
        final Value val, final int d) {
        Node<Value> y = x;
        char c = key.charAt(d);
        if (y == null) {
            y = new Node<Value>();
            y.c = c;
        }
        if (c < y.c) {
            y.left  = put(y.left,  key, val, d);
        } else if (c > y.c) {
            y.right = put(y.right, key, val, d);
        } else if (d < key.length() - 1) {
            y.mid   = put(y.mid,   key, val, d + 1);
        } else {
            y.val   = val;
        }
        return y;
    }
    /**
     * Returns the string in the symbol table that is the longest prefix of
     * {@code query},
     * or {@code null}, if no such string.
     * @param query the query string
     * @return the string in the symbol table that is the longest prefix
     * of {@code query},
     * or {@code null} if no such string
     * @throws IllegalArgumentException if {@code query} is {@code null}
     *
     * Complexity is L.
     */
    public String longestPrefixOf(final String query) {
        if (query == null) {
            throw new IllegalArgumentException(
                "calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) {
            return null;
        }
        int length = 0;
        Node<Value> x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char c = query.charAt(i);
            if      (c < x.c) {
                x = x.left;
            } else if (c > x.c) {
                x = x.right;
            } else {
                i++;
                if (x.val != null) {
                    length = i;
                }
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }

    /**
     * Returns all keys in the symbol table
     * as an {@code Iterable}.
     * To iterate over all of the keys
     * in the symbol table named {@code st},
     * use the foreach notation: {@code
     * for (Key key : st.keys())}.
     * @return all keys in the symbol table as an {@code Iterable}
     */
    public Iterable<String> keys() {
        Queue<String> queue = new Queue<String>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }

    /**
     * Returns all of the keys in the set that start with {@code prefix}.
     * @param prefix the prefix
     * @return all of the keys in the set that start with {@code prefix},
     *     as an iterable
     * @throws IllegalArgumentException if {@code prefix} is {@code null}
     *
     * Complexity is L. in worst case.
     */
    public Iterable<String> keysWithPrefix(final String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException(
                "calls keysWithPrefix() with null argument");
        }
        Queue<String> queue = new Queue<String>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) {
            return queue;
        }
        if (x.val != null) {
            queue.enqueue(prefix);
        }
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }
    /**
     * collect.
     *
     * Complexity is L.
     *
     * @param      x       { parameter_description }
     * @param      prefix  The prefix
     * @param      queue   The queue
     */
    private void collect(final Node<Value> x, final StringBuilder prefix,
        final Queue<String> queue) {
        if (x == null) {
            return;
        }
        collect(x.left,  prefix, queue);
        if (x.val != null) {
            queue.enqueue(prefix.toString() + x.c);
        }
        collect(x.mid,   prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }


    /**
     * Returns all of the keys in the symbol table that match {@code pattern},
     * where . symbol is treated as a wildcard character.
     * @param pattern the pattern
     * @return all of the keys in the symbol table that match {@code pattern},
     *     as an iterable, where . is treated as a wildcard character.
     */
    public Iterable<String> keysThatMatch(final String pattern) {
        Queue<String> queue = new Queue<String>();
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }
    /**
     * collect.
     *
     * @param      x        { parameter_description }
     * @param      prefix   The prefix
     * @param      i        { parameter_description }
     * @param      pattern  The pattern
     * @param      queue    The queue
     */
    private void collect(final Node<Value> x, final StringBuilder prefix,
        final int i, final String pattern, final Queue<String> queue) {
        if (x == null) {
            return;
        }
        char c = pattern.charAt(i);
        if (c == '.' || c < x.c) {
            collect(x.left, prefix, i, pattern, queue);
        }
        if (c == '.' || c == x.c) {
            if (i == pattern.length() - 1 && x.val != null) {
                queue.enqueue(prefix.toString() + x.c);
            }
            if (i < pattern.length() - 1) {
                collect(x.mid, prefix.append(x.c), i + 1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.c) {
            collect(x.right, prefix, i, pattern, queue);
        }
    }
}