import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String[] words = loadWords();
		//Your code goes here...
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		TST tst = new TST();
		System.out.println(tst.keysWithPrefix(s));
		//tst.keysWithPrefix(s);
	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}