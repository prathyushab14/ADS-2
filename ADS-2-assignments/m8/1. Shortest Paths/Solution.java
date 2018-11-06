import java.util.Scanner;
import java.util.HashMap;
/**
 *class for solution.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main method is to read the user.
     * input.
     *time complexity is O(E + V)
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map
        = new HashMap<String, Integer>();
        String[] tokens = sc.nextLine().split(" ");
        int edges = Integer.parseInt(tokens[1]);
        String[] ver = sc.nextLine().split(" ");
        for (int i = 0; i < ver.length; i++) {
            map.put(ver[i], i);
        }
        Edge e;
        EdgeWeightedGraph ewg
        = new EdgeWeightedGraph(ver.length);
        for (int i = 0; i < edges; i++) {
            String[] directPath = sc.nextLine().split(" ");
            e = new Edge(map.get(directPath[0]),
                               map.get(directPath[1]),
                               Double.parseDouble(directPath[2]));
            ewg.addEdge(e);
        }
        int queries = Integer.parseInt(sc.nextLine());
        DijkstraSP dsp;
        for (int i = 0; i < queries; i++) {
            String[] inp = sc.nextLine().split(" ");
            int source = map.get(inp[0]);
            dsp = new DijkstraSP(ewg, source);
            System.out.println((int) dsp.distance(map.get(inp[1])));
        }
    }
}
