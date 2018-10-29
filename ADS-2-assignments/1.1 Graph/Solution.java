import java.util.Scanner;
/**
 * Interface for graph.
 */
interface Graph {
    /**
     * no of vertices.
     *
     * @return    integer
     */
    int vertices();
    /**
     * no of edges.
     *
     * @return    integer
     */
    int edges();
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    void addEdge(int v, int w);
    /**
     * adds two vertices.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    Iterable<Integer> adj(int v);
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}
/**
 * Class for graph theory.
 */
class GraphTheory implements Graph {
    /**
     * vertices.
     */
    private int v;
    /**
     * edges.
     */
    private int e;
    /**
     * array of bag type.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     */
    GraphTheory() {
    }
    /**
     * Constructs the object.
     *
     * @param      v1    The v1
     */
    GraphTheory(final int v1) {
        this.v = v1;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v1];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Gets the v.
     *
     * @return     The v.
     */
    public int getV() {
        return v;
    }
    /**
     * Gets the e.
     *
     * @return     The e.
     */
    public int getE() {
        return e;
    }
    /**
     * get bag array.
     *
     * @return     list
     */
    public Bag<Integer>[] getadj() {
        return adj;
    }
    /**
     * returns number of vertices.
     *
     * @return    no of vertices
     */
    public int vertices() {
        return v;
    }
    /**
     * returns number of edges.
     *
     * @return    no of edges
     */
    public int edges() {
        return e;
    }
    /**
     * Adds an edge.
     * complexity of method is O(1)
     *
     * @param      v1    integer
     * @param      w1     integer
     */
    public void addEdge(final int v1, final int w1) {
        if (v1 == w1) {
            return;
        }
        if (!hasEdge(v1, w1)) {
            e++;
        adj[v1].add(w1);
        adj[w1].add(v1);
        }
    }
    /**
     * returns all the values in list.
     * complexity of this method is O(1)
     *
     * @param      v1     integer
     *
     * @return   list.
     */
    public Iterable<Integer> adj(final int v1) {
        return adj[v1];
    }
    /**
     * Determines if it has edge.
     * complexity of this method is O(N)
     *
     * @param      v1     integer
     * @param      w1     integer
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v1, final int w1) {
        for (int k : adj[v1]) {
                if (k == w1) {
                    return true;
                }
        }
        return false;
    }
    /**
     * display function of adjacency list.
     * complexity of this method is O(N^2)
     *
     * @param      v1         The v 1
     * @param      e1         The e 1
     * @param      tokens     The tokens
     *
     * @throws     Exception  { exception_description }
     */
    public void listdisplay(final int v1, final int e1,
        final String[] tokens) throws Exception {
        if (e1 <= 1 && v1 <= 1) {
            System.out.println(vertices() + " vertices" + ", "
                + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices() + " vertices" + ", "
                + edges() + " edges");
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
    /**
     * display function of adjacency matrix list.
     * complexity of this method is O(N^2)
     *
     * @param      v1         The v 1
     * @param      e1         The e 1
     *
     * @throws     Exception  No edges
     */
    public void matrixdisplay(final int v1, final int e1) throws Exception {
        if (e1 <= 1 && v1 <= 1) {
            System.out.println(vertices() + " vertices" + ", "
                + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices() + " vertices" + ", "
                + edges() + " edges");
            int[][] disp = new int[v1][v1];
            for (int i = 0; i  < v1; i++) {
                for (int j = 0; j < v1; j++) {
                    if (hasEdge(i, j)) {
                        disp[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < v1; i++) {
                for (int j = 0; j < v1; j++) {
                    System.out.print(disp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
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
        GraphTheory gph = new GraphTheory();
        String input = sc.nextLine();
        int v = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());
        String keynames = sc.nextLine();
        String[] tokens = keynames.split(",");
        gph = new GraphTheory(v);
        while (sc.hasNext()) {
            String connect = sc.nextLine();
            String[] connections = connect.split(" ");
            gph.addEdge(Integer.parseInt(connections[0]),
                Integer.parseInt(connections[1]));
        }
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
            default:
            break;
        }
    }
}

