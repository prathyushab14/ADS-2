import java.util.Scanner;
import java.util.*;
class PageRank {
	HashMap<Integer, Double> hm = new HashMap<>();
	Digraph graph;
	int no_v;
	int no_e;
	double initialPR;
	PageRank() {
    }
	PageRank(Digraph gr) {
		graph = gr;
		no_v = gr.V();
		no_e = gr.E();
		initialPR = 1 / no_v;
    }
	public double getPR(int v1) {
		double newPR;
		double pr = initialPR;
		for (int i = 0; i < no_v; i++) {
			hm.put(i, initialPR);
		}
		graph.reverse();
		for (int v : graph.adj(v1)) {
			for (int i = 0; i < 1000; i++) {
			    newPR = pr / graph.outdegree(v);
			    pr = newPR;
			}
		}
		return pr;
    }
	public String toString() {
		String str = "";
		System.out.println(no_v + " vertices" + ", "+ no_e + " edges");
        for (int i = 0; i < no_v; i++) {
            str = i + ": ";
            for (int k : graph.adj(i)) {
                str = str + k + " ";
            }
            System.out.println(str);
        }
        System.out.println();
        String rstr = "";
        for (int i = 0; i < no_v; i++) {
        	rstr += i + " - " + getPR(i) +"\n";
        }
        System.out.println(rstr);
        return "";
	}
}
class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Digraph gph = new Digraph();
		// read the first line of the input to get the number of vertices
		int v = Integer.parseInt(sc.nextLine());
		Digraph gph = new Digraph(v);
        // iterate count of vertices times
        // to read the adjacency list from std input
		// and build the graph
        for (int i = 0; i < v; i++) {
        	String input = sc.nextLine();
        	String[] tokens = input.split(" ");
        	for (int j = 1; j < tokens.length; j++) {
                gph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[j]));
        	}
        } 
		// Create page rank object and pass the graph object to the constructor
		PageRank pr = new PageRank(gph);
		// print the page rank object
		System.out.println(pr);
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
