import java.util.Scanner;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ver = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(ver);
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split(" ");
			Edge e = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
			//EdgeWeightedGraph ewg = new EdgeWeightedGraph(ver);
			ewg.addEdge(e);
        }
        KruskalMST kmst = new KruskalMST(ewg);
        System.out.println(kmst.weight());
    }
}