package com.nayan.code.assessments.april_2020;

import java.util.*;

public class Codility_Klarna_2 {

    public static void main(String[] args) {
        int blockSize = 10;
        int fileSize = 2;
        Set<Integer> occupiedSectors = new HashSet<>();
        occupiedSectors.add(9);
        occupiedSectors.add(6);
        occupiedSectors.add(3);

        int remainingSectors = blockSize - occupiedSectors.size();

        if(fileSize > remainingSectors) {
            System.out.println("false");
        } else if(blockSize == fileSize && occupiedSectors.size() == 0) {

        }

        occupiedSectors.add(1);
        occupiedSectors.add(blockSize);

        List<Integer> sortList = new ArrayList<>(occupiedSectors);
        Collections.sort(sortList);

        for(int i=0; i< sortList.size() - 1; i++) {
            if ((sortList.get(i+1) - sortList.get(i) -1 ) >= fileSize) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }
}