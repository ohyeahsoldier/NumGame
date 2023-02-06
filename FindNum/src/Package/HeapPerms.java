package Package;
import java.util.ArrayList;
import java.util.Arrays;

public class HeapPerms <T> {
	private ArrayList<T[]> Permutations = new ArrayList<T[]>();
    HeapPerms(T[] input) {
		heapPermutation(input, input.length); //seems like using 0 instead of input.length can also work... idk
	}

    public void heapPermutation(T[] input, int size) {
		// When size becomes one then the permutation has been generated	
		if (size == 1) {
			T[] clone = Arrays.copyOf(input,input.length); //input.length so it has same length
            Permutations.add(clone);
        }
		for (int i = 0; i < size; i++) {
			heapPermutation(input, size - 1); //idk how this recursion works lol

			// If size is even, swap `i`th & last element
			if (size % 2 == 0) {
				T temp = input[i];
				input[i] = input[size - 1];
				input[size - 1] = temp;
			}
			// if size is odd, swap the First & Last element
			else {
				T temp = input[0];
				input[0] = input[size - 1];
				input[size - 1] = temp;
			}
		}
	}

	public void print() {
        System.out.println("\n");
		for (int i=0; i < Permutations.size(); i++) {
			for (T temp : Permutations.get(i)) {
				System.out.print(temp+" ");
			}
			System.out.println();
		}
	}
	public ArrayList<T[]> perms() { return Permutations; }
}
