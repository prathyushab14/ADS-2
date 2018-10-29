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
		if (v == w) {
        	return;
        }
		if (!hasEdge(v,w)) {
            e++;
            
        }
        
        adj[v].add(w);
        adj[w].add(v);
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
    public void listdisplay(int v, int e, String[] tokens) throws Exception {
    	if (e <= 1 && v <= 1) {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		throw new Exception("No edges");
    	} else {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		for (int i = 0; i < tokens.length; i++) {
			String str = "";
			str = tokens[i] + ": ";
			for (int k : adj(i)) {
				str = str + tokens[k] + " ";
			}
			System.out.println(str);
			}
    	}
    }

    public void matrixdisplay(int v, int e) throws Exception {
    	if (e <= 1 && v <= 1) {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		throw new Exception("No edges");
    	} else {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		int[][] disp = new int[v][v];
    		for (int i = 0; i  < v; i++) {
    			for (int j = 0; j < v; j++) {
    				if (hasEdge(i, j)) {
    					disp[i][j] = 1;
		    		}
    			}
    		}

    		for (int i = 0; i < v; i++) {
    			for (int j = 0; j < v; j++) {
    				System.out.print(disp[i][j] + " ");
    			}
    			System.out.println();
    		}
    		
    	}
    }
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GraphTheory gph = new GraphTheory();
		String input = sc.nextLine();
		
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());
		String keynames = sc.nextLine();
		String[] tokens = keynames.split(",");
		//BinarySearchST<Integer, String> bst = new BinarySearchST<Integer, String>();
		gph = new GraphTheory(v);
		while(sc.hasNext()) {
			String connect = sc.nextLine();
			String[] connections = connect.split(" ");
			gph.addEdge(Integer.parseInt(connections[0]), Integer.parseInt(connections[1]));
		}
		//String str = "";

		switch (input) {
			case "List":
			try {
				gph.listdisplay(v, e, tokens);
			} catch (Exception p) {
				System.out.println(p.getMessage());
			}
			break;
			case "Matrix":
			try {
				gph.matrixdisplay(v, e);
			} catch (Exception p) {
				System.out.println(p.getMessage());
			}
			break;
		}

		
		
	}
}

