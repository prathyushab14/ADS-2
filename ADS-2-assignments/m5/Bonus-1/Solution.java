import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution() {
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		String[] inputs = inp.split(" ");
		int v = Integer.parseInt(inputs[0]);
		int e = Integer.parseInt(inputs[1]);
		if (e == 0) {
			System.out.println(e);
		} else {
			Graph gph = new Graph(v + 1);
			while (sc.hasNext()) {
			String connect = sc.nextLine();
			String[] connects = connect.split(" ");
			gph.addEdge(Integer.parseInt(connects[0]), Integer.parseInt(connects[1]));
        }
        CC connected = new CC(gph);
        int count = 0;
        
        int finalcnt = 0;
        int id = 0;
        int[] idarr = connected.idarray();
        //System.out.println(Arrays.toString(idarr));
        for (int i = 0; i < gph.vertices(); i++) {
        	if (gph.hasParallelEdges(i)) {
        		count++;
        	}
        	int idcnt = 0;
        	id = idarr[i];
        	//System.out.println(id);
        	for (int j = 0; j < idarr.length; j++) {
        		if (id == idarr[j]) {
        			idcnt++;
        		}
        	}
        	if (finalcnt < idcnt) {
        	    finalcnt = idcnt;	
        	}
        }
        System.out.println(finalcnt);
		}
		
	}
} 