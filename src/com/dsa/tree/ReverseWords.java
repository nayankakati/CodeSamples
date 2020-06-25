package dsa.tree;

/**
 * Created by nayan.kakati on 2/20/18.
 */
public class ReverseWords {

	public static void main(String args[]) {
		String str = "we test coders";

		String[] strSplit = str.split(" ");

		StringBuilder resultStr = new StringBuilder();

		for(int i = 0 ; i < strSplit.length;i++) {
			StringBuilder tempStr = new StringBuilder(strSplit[i]);
			if(i != strSplit.length - 1) {
				resultStr.append(tempStr.reverse()).append(" ");
			} else {
				resultStr.append(tempStr.reverse());
			}
		}
		System.out.println(resultStr.toString());
		System.out.println(resultStr.toString().length());
	}
}
