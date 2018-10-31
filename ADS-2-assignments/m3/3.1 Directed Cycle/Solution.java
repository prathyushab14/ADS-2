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
        int v = Integer.parseInt(sc.nextLine());
        Digraph gph = new Digraph(v);
        int e = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String tokens = sc.nextLine();
            String[] tok = tokens.split(" ");
            gph.addEdge(Integer.parseInt(tok[0]), Integer.parseInt(tok[1]));
        }
        Cycle c = new Cycle(gph);
        if (c.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }
    }
}