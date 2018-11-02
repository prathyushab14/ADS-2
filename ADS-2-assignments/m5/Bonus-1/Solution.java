import java.util.Scanner;
class Solution {
	Solution() {
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		String[] inputs = inp.split(" ");
		int v = Integer.parseInt(inputs[0]);
		Graph gph = new Graph(v);
		CC connected = new CC(gph);
		int e = Integer.parseInt(inputs[1]);
		while (sc.hasNext()) {
			String connect = sc.nextLine();
			String[] connects = connect.split(" ");
			gph.addEdge(Integer.parseInt(connects[0]), Integer.parseInt(connects[1]));
			System.out.println(connected.id(Integer.parseInt(connects[0])));
			//connected.id(connects[0])
        }


	}
} 