package dsa.tree;

/**
 * Created by nayan.kakati on 2/20/18.
 */
public class LowestNumberIn2Arrays {

	public static void main(String args[]) {
		int A[] = {1,3,2,1};
		int B[] = {4,2,5,3,2,1};
		int smallest = 1000000000;

		for(int i=0; i< A.length;i++) {
			for(int j=0;j< B.length;j++) {
				if(A[i] == B[j]) {
					if(A[i] < smallest)
						smallest = A[i];
				}
			}
		}
		System.out.println(smallest);
	}
}
