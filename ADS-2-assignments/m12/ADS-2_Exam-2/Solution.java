import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_v = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(no_v);
		int no_e = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < no_v; i++) {
		    String[] str = sc.nextLine().split(" ");
		    Edge e = new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Double.parseDouble(str[2]));
		    ewg.addEdge(e);
		}
		while (sc.hasNext()) {
        String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
		    System.out.println(no_v + " vertices " + no_e + " edges");
            System.out.println(ewg);
            break;
        case "DirectedPaths":
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
			String[] inp = sc.nextLine().split(" ");
			int sou = Integer.parseInt(inp[0]);
			int via = Integer.parseInt(inp[1]);
			int des = Integer.parseInt(inp[2]);
			double d1 = 0.0;
			double d2 = 0.0;
			DijkstraUndirectedSP dp = new DijkstraUndirectedSP(ewg, sou);
            if (!dp.hasPathTo(des)) {
                System.out.println("No Path Found.");
            }
			break;
		default:
			break;
		}
	}

	}
}