/**
 * Class for depth first search.
 */
class DepthFirstSearch {
    /**
     * marked array of boolean type.
     */
    private boolean[] marked;
    /**
     * count.
     */// marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s

    /**
     * Computes the vertices in graph {@code G} that are
     * connected to the source vertex {@code s}.
     * @param gp the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    DepthFirstSearch(final Digraph gp, final int s) {
        marked = new boolean[gp.V()];
        validateVertex(s);
        dfs(gp, s);
    }
    /**
     * depth first search.
     *
     * @param      gp    { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Digraph gp, final int v) {
        count++;
        marked[v] = true;
        for (int w : gp.adj(v)) {
            if (!marked[w]) {
                dfs(gp, w);
            }
        }
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean marked(final int v) {
        validateVertex(v);
        return marked[v];
    }

    /**
     * Returns the number of vertices connected to the source vertex {@code s}.
     * @return the number of vertices connected to the source vertex {@code s}
     */
    public int count() {
        return count;
    }
    /**
     * validate vertex function.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int m = marked.length;
        if (v < 0 || v >= m) {
            throw new IllegalArgumentException("vertex " + v
                + " is not between 0 and " + (m - 1));
        }
    }
}