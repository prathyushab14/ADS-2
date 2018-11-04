import java.util.Scanner;
class EdgeConnectivity {
	int   bridges; // number of bridges
    int   count;    // counter
    int[] preord;    // pre[v] = order in which dfs examines v
    int[] lowpre;    // low[v] = lowest preorder of any vertex connected
                           // to v
 
    public EdgeConnectivity(Graph gph)
    {
        lowpre = new int[gph.vertices()];
        preord = new int[gph.vertices()];
        for (int v = 0; v < gph.vertices(); v++)
            lowpre[v] = -1;
        for (int v = 0; v < gph.vertices(); v++)
            preord[v] = -1;
        for (int v = 0; v < gph.vertices(); v++)
            if (preord[v] == -1)
                dfs(gph, v, v);
    }
    public int bridges()
    {
        return bridges;
    }
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
                    // System.out.println(v + "-" + w + " is a bridge");
                    bridges++;
                }
            }
            // update low number - ignore reverse of edge leading to v
            else if (w != u)
                lowpre[v] = Math.min(lowpre[v], preord[w]);
        }
    }
} 
class Solution {
	Solution() {

	}
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
        	System.out.println(ec.bridges + "Bridges");
        } else {
        	System.out.println("No Bridge");
        }
	}
}