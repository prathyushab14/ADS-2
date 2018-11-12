import java.util.*;
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = Integer.parseInt(sc.nextLine());
    	String[] str = new String[n];
    	Quick3string qs = new Quick3string();
    	for (int i = 0; i < n; i++) {
    		str[i] = sc.nextLine();
        }
        qs.sort(str);
        System.out.println(Arrays.toString(str));
    }
}