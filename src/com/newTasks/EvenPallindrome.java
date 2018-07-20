package com.newTasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nayan.kakati on 6/3/18.
 */
public class EvenPallindrome {

	public static void main(String[] args) {
		int testCases = 1;
		int n[] = new int[testCases];
		n[0] = 1;
		//n[1] = 2;
		//n[2] = 10;

		for (int i=0; i<testCases; i++) {
			String nmbr = String.valueOf(n[i]);
			StringBuilder builder = new StringBuilder();
			builder.append(nmbr);
			String actualNumber = nmbr.concat(builder.reverse().toString());
			getEvenLengthNumber(actualNumber);
		}

	}

	private static int getEvenLengthNumber(String nmber) {
		Integer parsedNumber = Integer.valueOf(nmber);
		int[]digits = Integer.toString(parsedNumber).chars().map(c -> c-'0').toArray();
		Map<Integer, Integer> counties = new HashMap<>();
		for(int i=0 ;i< digits.length; i++) {
			Integer count = counties.get(digits[i]);
			if(count != null)
				count ++;
			else count = 1;
			counties.put(digits[i], count);
		}

		for (int i=0; i< counties.size(); i++) {
			System.out.println(counties.get(i));
		}
		return 0;
	}
}
