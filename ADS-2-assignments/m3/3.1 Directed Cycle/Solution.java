import java.util.Scanner;
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int v = Integer.parseInt(sc.nextLine());
    	Digraph gph = new Digraph(v);
    	Cycle c = new Cycle(gph);
    	int e = Integer.parseInt(sc.nextLine());
    	String tokens = sc.nextLine();
    	String[] tok = tokens.split(" ");
    	gph.addEdge(Integer.parseInt(tok[0]), Integer.parseInt(tok[1]));
    	// System.out.println(c.hasCycle());
    	if (c.hasCycle() || c.hasParallelEdges(gph) || c.hasSelfLoop(gph)) {
            System.out.println("Cycle exists.");
    	} else {
    		System.out.println("Cycle doesn't exists.");
    	}
    }
}