import java.util.*;
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}
class GraphTheory implements Graph {
	int v;
    int e;
    Bag<Integer>[] adj;
    GraphTheory() {

    }
    public GraphTheory(int v1) {
        this.v = v1;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v1];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
	public int V() {
		return v;
    }
	public int E() {
		return e;
    }
	public void addEdge(int v, int w) {
		if (!hasEdge(v,w)) {
            e++;
            adj[v].add(w);
            adj[w].add(v);
        }
    }
	public Iterable<Integer> adj(int v) {
        return adj[v];
    }
	public boolean hasEdge(int v, int w) {
		for(int k :adj[v]) {
				if (k==w) {
					return true;
				}
		}
		return false;
    }
    // public String toString() {
    // 	for (int i = 0; i < adj.length; i++) {
    // 		System.out.println();
    // 	}
    // }
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GraphTheory gph = new GraphTheory();
		String input = sc.nextLine();
		switch (input) {
			case "List":
			break;
			case "Matrix":
			break;
		}
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());
		String keynames = sc.nextLine();
		String[] tokens = keynames.split(",");
		//BinarySearchST<Integer, String> bst = new BinarySearchST<Integer, String>();
		gph = new GraphTheory(tokens.length);
		while(sc.hasNext()) {
			String connect = sc.nextLine();
			String[] connections = connect.split(" ");
			gph.addEdge(Integer.parseInt(connections[0]), Integer.parseInt(connections[1]));
		}
		//String str = "";
		System.out.println(v + "vertices" + ", " + e + "edges");
		for (int i = 0; i < tokens.length; i++) {
			String str = "";
			str = tokens[i] + ":";
			for (int k : gph.adj(i)) {
				str = str + tokens[k] + " ";
			}
			System.out.println(str);
		}
	}
}

