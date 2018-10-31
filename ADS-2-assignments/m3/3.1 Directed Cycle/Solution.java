import java.util.Scanner;
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int v = Integer.parseInt(sc.nextLine());
    	Digraph gph = new Digraph(v);
    	int e = Integer.parseInt(sc.nextLine());
    	String tokens = sc.nextLine();
    	String[] tok = tokens.split(" ");
    	gph.addEdge(Integer.parseInt(tok[0]), Integer.parseInt(tok[1]));
    	Cycle c = new Cycle(gph);
    	// System.out.println(c.hasCycle());
    	if (c.hasCycle()) {
            System.out.println("Cycle exists.");
    	} else {
    		System.out.println("Cycle doesn't exists.");
    	}
    }
}