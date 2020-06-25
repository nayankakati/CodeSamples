package com.nayan.code.assessments.may_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        Object[] ab = new Object[]{"qwe","qw", null, "ghs"};
        Arrays.asList(ab);
       // String[] str = sol.solution(4,2);
        //System.out.println(str);
    }
    public String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K - 1)) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K) <= 0 ? result.size() : Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }
}
