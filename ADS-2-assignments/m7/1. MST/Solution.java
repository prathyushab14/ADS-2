import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int ver = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(ver);
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            Edge e = new Edge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            ewg.addEdge(e);
        }
        KruskalMST kmst = new KruskalMST(ewg);
        System.out.format("%.5f", kmst.weight());
    }
}
