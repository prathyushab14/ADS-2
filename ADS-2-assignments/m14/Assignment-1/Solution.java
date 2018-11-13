import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String[] words = loadWords();
		//Your code goes here...
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		TST<Integer> tst = new TST<Integer>();
		for (int i = 0; i < words.length; i++) {
			tst.put(words[i], i);
			System.out.println(words[i]);
		}
		for (String str : tst.keysWithPrefix(s)) {
			System.out.println(str);
		}
	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}