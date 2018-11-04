import java.util.Scanner;
/**
 * Class for edge connectivity.
 */
class EdgeConnectivity {
	/**
	 * bridges variable.
	 */
	int   bridges; // number of bridges
	/**
	 * count variable.
	 */
    int   count;    // counter
    /**
     * preord array of integer type.
     */
    int[] preord;    // pre[v] = order in which dfs examines v
    /**
     * lowpre array of integer type.
     */
    int[] lowpre;    // low[v] = lowest preorder of any vertex connected to v
    /**
     * Constructs the object.
     *
     * @param      gph   The gph
     */
    EdgeConnectivity(final Graph gph) {
        lowpre = new int[gph.vertices()];
        preord = new int[gph.vertices()];
        for (int v = 0; v < gph.vertices(); v++) {
            lowpre[v] = -1;
        }
        for (int v = 0; v < gph.vertices(); v++) {
            preord[v] = -1;
        }
        for (int v = 0; v < gph.vertices(); v++) {
            if (preord[v] == -1) {
                dfs(gph, v, v);
            }
        }
    }
    /**
     * no of bridges.
     *
     * @return     number of bridges.
     */
    public int bridges()
    {
        return bridges;
    }
    /**
     * depth first search.
     *
     * @param      gph   The graph object.
     * @param      u     integer
     * @param      v     integer
     */
    private void dfs(Graph gph, int u, int v)
    {
        preord[v] = count++;
        lowpre[v] = preord[v];
        for (int w : gph.adj(v))
        {
            if (preord[w] == -1)
            {
                dfs(gph, v, w);
                lowpre[v] = Math.min(lowpre[v], lowpre[w]);
                if (lowpre[w] == preord[w])
                {
                    bridges++;
                }
            }
            else if (w != u) {
                lowpre[v] = Math.min(lowpre[v], preord[w]);
            }
        }
    }
}
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.nextLine());
		Graph gph = new Graph(v);
		int e = Integer.parseInt(sc.nextLine());
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(" ");
			gph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
        EdgeConnectivity ec = new EdgeConnectivity(gph);
        if (ec.bridges() != 0) {
        	System.out.println(ec.bridges + " Bridges");
        } else {
        	System.out.println("No Bridge");
        }
	}
}