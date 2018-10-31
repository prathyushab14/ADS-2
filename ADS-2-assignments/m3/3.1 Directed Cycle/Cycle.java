/**
 * Class for cycle.
 */
public class Cycle {
    /**
     * { var_description }
     */
    private boolean[] marked;// marked[v] = has vertex v been marked?
    /**
     * { item_description }
     */
    private int[] edgeTo;
    /**
     * { var_description }
     */
    private boolean[] onStack;
    /**
     * { var_description }
     */
    private Stack<Integer> cycle;
    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param G the digraph
     */
    public Cycle(Digraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(G, v);
            }
        }
    }
    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) {
                return;
            }
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    /**
     * Does the digraph have a directed cycle?
     * @return true or false
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * Returns a directed cycle if the digraph has a directed cycle, and {@code null} otherwise.
     *
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}