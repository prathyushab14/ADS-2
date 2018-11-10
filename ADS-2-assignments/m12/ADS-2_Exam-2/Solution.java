import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int no_v = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(no_v);
		int no_e = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < no_v; i++) {
		    String[] str = sc.nextLine().split(" ");
		    Edge e = new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Double.parseDouble(str[2]));
		    ewg.addEdge(e);
		}
        String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
		    System.out.println(no_v + " vertices " + no_e + " edges");
            System.out.println(ewg);
            break;
        case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] tok = sc.nextLine().split(" ");
			int so = Integer.parseInt(tok[0]);
			int de = Integer.parseInt(tok[1]);
			DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(ewg,so);
			if (dsp.hasPathTo(de)) {
				System.out.println(dsp.distTo(de));
			} else {
				System.out.println("No Path Found.");
			}
			break;

	

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] inp = sc.nextLine().split(" ");
			int sou = Integer.parseInt(inp[0]);
			int via = Integer.parseInt(inp[1]);
			int des = Integer.parseInt(inp[2]);
			break;
		default:
			break;
		}

	}
}