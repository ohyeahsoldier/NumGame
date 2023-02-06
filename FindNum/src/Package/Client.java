package Package;
import java.util.ArrayList;
import java.util.Arrays;

class Client {
	public static ArrayList<char[]> Operations = new ArrayList<>();
	private static void permutation(char[] perm, int pos, String str) {
		if (pos == perm.length) {
			Operations.add(Arrays.copyOf(perm,perm.length));
		} else {
			for (int i = 0 ; i < str.length() ; i++) {
				perm[pos] = str.charAt(i);
				permutation(perm, pos+1, str);
			}
		}
	}

	public static void main(String[] args) {
		//
		Integer[] input = {1,2,3};
		HeapPerms<Integer> Perms = new HeapPerms(input); //My generic implementation that doesnt allow repeats
		Perms.print();
		ArrayList<Integer[]> Permutations = Perms.perms();

		char[] perm = new char[input.length];
		permutation(perm, 0, "+-*/"); //Allows repeats


		int target = 25;
		// Parse through and see if it results in target
		for (Integer[] array : Permutations) {
			for (char[] math : Operations) {
				int sum = 0;
				for (int i=0; i<array.length; i++) { //note array.len should == math.len
					switch (math[i]) {
						case '+':
						case '-':
						case '*':
						case '/':
					}
				}
			}
		}
		//
	}
	//https://stackoverflow.com/questions/21461084/how-to-find-the-exact-set-of-operations-for-a-specific-number
	//https://stackoverflow.com/questions/29919158/get-every-permutation-of-a-mathematical-expression
}