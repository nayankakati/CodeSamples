package dsa.tree;

import java.util.Arrays;

/**
 * Created by nayan.kakati on 2/20/18.
 */
public class SortArrayWithOneSwap {

	public static void main(String...args) {
		int A[] = {1,3,5,3,4};
		int B[] = Arrays.copyOf(A, A.length);
		int position = 0;
		Arrays.sort(A);
		System.out.println(A);

		for(int i=0; i<A.length;i++) {
			System.out.println(A[i]+ " " + B[i]);
			if(A[i] != B[i])
				position ++;
		}
			System.out.println(position);

	}
}
