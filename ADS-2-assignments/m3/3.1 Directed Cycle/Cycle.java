/**
 * Class for cycle.
 */
public class Cycle {
    /**
     * { var_description.
     */
    private boolean[] marked; // marked[v] = has vertex v been marked?
    /**
     * { item_description.
     */
    private int[] edgeTo;
    /**
     * { var_description.
     */
    private boolean[] onStack;
    /**
     * { var_description.
     */
    private Stack<Integer> cycle;
    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param G the digraph
     */
    public Cycle(final Digraph gp) {
        marked  = new boolean[gp.V()];
        onStack = new boolean[gp.V()];
        edgeTo  = new int[gp.V()];
        for (int v = 0; v < gp.V(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(gp, v);
            }
        }
    }
    /**
     * { function_description.
     *
     * @param      gp    { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Digraph gp, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : gp.adj(v)) {
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(gp, w);
            } else if (onStack[w]) {
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
     * Returns a directed cycle if the digraph has a directed cycle
     *
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}