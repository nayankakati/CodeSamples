package com.nayan.code.assessments.april_2020;

import java.util.*;

public class Rakuten {

    public static void main(String[] args){
        Rakuten  rakuten = new Rakuten();
        System.out.println(rakuten.helper(6,1,1));
    }

    public String helper(int A, int B, int C)
    {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', A);
        map.put('b', B);
        map.put('c', C);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->(b.val!=a.val?b.val-a.val:a.c-b.c));
        for(char c: map.keySet()) {
            if (map.get(c) > 0)
                pq.offer(new Pair(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            int i = 0;
            List<Pair> tempList = new ArrayList<>();
            while(i<3&&!pq.isEmpty()) //we are not allowed to poll a char twice in a cycel (len=3 or 4)
            {
                Pair p = pq.poll();
                if(p.val>=2) //main diff from rearrage string k distance apart
                {
                    sb.append(p.c);
                    sb.append(p.c);
                    p.val--;
                    p.val--;
                    i++;
                    i++;
                }else{
                    sb.append(p.c);
                    p.val--;
                    i++;
                }
                if(p.val!=0) tempList.add(p); //when p.val==0, remove it
            }
            //3 or 4 are both fine here, but it cannot be less than 3
            if(i<3&&tempList.size()>0) return sb.toString(); //if i<k, but it's the last cycle, it's fine

            for(Pair p:tempList)
                pq.offer(p);
        }
        return sb.toString();
    }

    class Pair{
        char c;
        int val;
        Pair(char c, int val)
        {
            this.c = c;
            this.val = val;
        }

    }
    /*{
        int A = 0;
        int B = 1;
        int C = 8;

        int d = A +B +C;

        StringBuilder builder = new StringBuilder();

        int currentA = 0, currentB =0, currentC=0;
        while (d > 0) {

            if(A > 0 && currentA < 2) {
                builder.append("a");
                A--;
                d--;
                currentA ++;
                continue;
            } else if (currentB < 2 || currentC < 2) {
                currentA =0 ;
            }

            if (B > 0 && currentB < 2) {
                builder.append("b");
                B--;
                d--;
                currentB ++;
                continue;
            } else if (currentC < 2 || currentA < 2) {
                currentB =0 ;
            }

            if (C > 0 && currentC < 2) {
                builder.append("c");
                C--;
                d--;
                currentC++;
            } else if (currentB < 2 || currentA < 2) {
                currentC =0 ;
            }

        }
        System.out.println(builder.toString());
    }*/
}
